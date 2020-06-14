package com.mycompany.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.project.model.Board;
import com.mycompany.project.model.Rating;
import com.mycompany.project.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list.do")
	public String list(Model model, HttpSession session) {
		session.setAttribute("updateStatus", null);
		LOGGER.info("실행");
		List<Board> list = boardService.getList();
		model.addAttribute("boardlist", list);
		return "board/list";
	}

	@GetMapping("/write.do")
	public String writeForm() {
		LOGGER.info("실행");
		return "board/writeForm";
	}

	@PostMapping("/write.do")
	public String write(Board board, HttpSession session) throws Exception {
		LOGGER.info("실행");

		String mid = (String) session.getAttribute("sessionMid");
		board.setBwriter(mid);

		MultipartFile posterFile = board.getBposter();
		MultipartFile videoFile = board.getBvideo();
		if (!posterFile.isEmpty() || !videoFile.isEmpty()) {
			String saveDir = "C:/MyWorkspace/attachs/";
			String savePosterFileName = new Date().getTime() + "-" + posterFile.getOriginalFilename();
			String saveVideoFileName = new Date().getTime() + "-" + videoFile.getOriginalFilename();
			File posterFilePath = new File(saveDir + savePosterFileName);
			File videoFilePath = new File(saveDir + saveVideoFileName);
			posterFile.transferTo(posterFilePath);
			videoFile.transferTo(videoFilePath);
			board.setBposteroname(posterFile.getOriginalFilename());
			board.setBpostersname(savePosterFileName);
			board.setBpostertype(posterFile.getContentType());
			board.setBvideooname(videoFile.getOriginalFilename());
			board.setBvideosname(saveVideoFileName);
			board.setBvideotype(videoFile.getContentType());
		} else {
			return "redirect:/board/write.do";
		}

		boardService.write(board);
		return "redirect:/board/list.do";
	}

	@RequestMapping("/detail.do")
	public String detail(int bno, int cno, Model model) {
		boardService.updateBhitcountByBno(bno);
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("cno", cno);
		model.addAttribute("rating", Math.round((board.getBtotalrating()/board.getBratingcount())*10)/10.0);
		
		return "board/detail";
	}

	@RequestMapping("/delete.do")
	public String delete(int bno, HttpSession session) {
		session.setAttribute("updateStatus", null);
		Board getBoard = boardService.getBoard(bno);
		String mid = (String)session.getAttribute("sessionMid");
		// 파일도 함께 삭제
		File posterFileDelete = new File("C:/myworkspace/attachs/" + getBoard.getBpostersname());
		File videoFileDelete = new File("C:/myworkspace/attachs/" + getBoard.getBvideosname());
		posterFileDelete.delete();
		videoFileDelete.delete();
		boardService.deleteRatingByBnoAndMid(bno, mid);
		boardService.deleteBoard(bno);
		return "redirect:/board/list.do";
	}

	@GetMapping("/bposterDownload.do")
	public void bposterDownload(int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board board = boardService.getBoard(bno);

		String filePath = "C:/MyWorkspace/attachs/" + board.getBpostersname();

		// 파일의 형식
		response.setContentType(board.getBpostertype());

		// Body에 파일 데이터 쓰기
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
		os.close();
		is.close();
	}
	
	@GetMapping("/bvideoDownload.do")
	public void videodownload(int bno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board board = boardService.getBoard(bno);

		String filePath = "C:/MyWorkspace/attachs/" + board.getBvideosname();

		// 파일의 형식
		response.setContentType(board.getBvideotype());

		// Body에 파일 데이터 쓰기
		InputStream is = new FileInputStream(filePath);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
		os.close();
		is.close();
	}

	@GetMapping("/update.do")
	public String updateForm(int bno, Model model, HttpSession session) {
		//!!
		session.setAttribute("updateStatus", null);
		LOGGER.info("539583953975{}", bno);
		Board board = boardService.getBoard(bno);
		
		model.addAttribute(board);
		return "board/updateForm";
	}

	@PostMapping("/update.do")
	public String update(Board board) throws Exception {
		
		LOGGER.info("{}", board.getBno());
		// 기존 포스터를 요청한 bno로 가져오기.
		Board getBoard = boardService.getBoard(board.getBno());
		MultipartFile posterFile = board.getBposter();
		MultipartFile videoFile = board.getBvideo();
		// 날짜를 수정 요청한 시간으로 수정.
		board.setBdate(new Date());
		// 파일 삭제를 위해 기존 파일의 경로를 저장.
		File posterFileDelete = new File("C:/myworkspace/attachs/" + getBoard.getBpostersname());
		File videoFileDelete = new File("C:/myworkspace/attachs/" + getBoard.getBvideosname());
		// 새로운 파일이 업로드 되면 기존 파일 삭제 후 다시 저장
		// 포스터
		if (!posterFile.isEmpty()) {
			posterFileDelete.delete();
			String saveDir = "C:/MyWorkspace/attachs/";
			String saveFileName = new Date().getTime() + "-" + posterFile.getOriginalFilename();
			File filepath = new File(saveDir + saveFileName);
			posterFile.transferTo(filepath);
			board.setBposteroname(posterFile.getOriginalFilename());
			board.setBpostersname(saveFileName);
			board.setBpostertype(posterFile.getContentType());
		} else {
			// 파일을 수정하지 않으면 기존 것으로 유지.
			board.setBpostertype(getBoard.getBpostertype());
			board.setBpostersname(getBoard.getBpostersname());
			board.setBposteroname(getBoard.getBposteroname());
		}
		if (!videoFile.isEmpty()) {
			videoFileDelete.delete();
			String saveDir = "C:/MyWorkspace/attachs/";
			String saveFileName = new Date().getTime() + "-" + videoFile.getOriginalFilename();
			File filepath = new File(saveDir + saveFileName);
			videoFile.transferTo(filepath);
			board.setBvideooname(videoFile.getOriginalFilename());
			board.setBvideosname(saveFileName);
			board.setBvideotype(videoFile.getContentType());
		} else {
			// 파일을 수정하지 않으면 기존 것으로 유지.
			board.setBvideotype(getBoard.getBvideotype());
			board.setBvideosname(getBoard.getBvideosname());
			board.setBvideooname(getBoard.getBvideooname());
		}
		// 변경내용을 db로 저장
		boardService.updateByBno(board);
		return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
	}

	@PostMapping("/rating.do")
	public String rating(Board board, Rating rating, HttpSession session,Model model ) {
		session.setAttribute("updateStatus", null);
		// 해당 번호 보드 가져오기
		Board getBoard = boardService.getBoard(board.getBno());
		// 세션의 mid 가져오기
		String mid = (String) session.getAttribute("sessionMid");
		// 레이팅에 게시물번호와 아이디가 같은게 있는지 담기 없으면 null
		Rating getRating = boardService.getRating(board.getBno(), mid);
		if (getRating == null) {
			LOGGER.info("겟레이팅 없을 널일때");
			// 레이팅모델 정보 담고 db에 넣기
			rating.setBno(board.getBno());
			rating.setMid(mid);
			rating.setMidrating(board.getBtotalrating());
			boardService.insertRating(rating);
			// 평점을 주면 레이팅카운트 1증가
			int count = getBoard.getBratingcount() + 1;
			board.setBratingcount(count);
			// 기존 토탈레이팅에 요청 레이팅 더하기
			double totalRating = getBoard.getBtotalrating() + board.getBtotalrating();
			board.setBtotalrating(totalRating);
			boardService.updateRatingByBno(board);
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		} else {
			// 이미 별점을 주었을 때
			
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		}

	}
	
	@PostMapping("/ratingdelete.do")
	public String ratingDelete(Board board, HttpSession session) {
		session.setAttribute("updateStatus", null);
		Board getBoard = boardService.getBoard(board.getBno());
		String mid = (String)session.getAttribute("sessionMid");
		Rating getRating = boardService.getRating(board.getBno(), mid);
		if(getRating != null) {
			double totalRating = getBoard.getBtotalrating()-getRating.getMidrating();
			int count = getBoard.getBratingcount()-1;
			board.setBtotalrating(totalRating);
			board.setBratingcount(count);
			boardService.deleteRatingByBnoAndMid(board.getBno(), mid);
			boardService.updateRatingByBno(board);
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		}else {
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		}
	}
	
	@PostMapping("/ratingupdate.do")
	public String ratingUpdate(Board board, HttpSession session) {
		session.setAttribute("updateStatus", null);
		Board getBoard = boardService.getBoard(board.getBno());
		String mid = (String)session.getAttribute("sessionMid");
		Rating getRating = boardService.getRating(board.getBno(), mid);
		if(getRating != null) {
			double totalRating = getBoard.getBtotalrating()-getRating.getMidrating()+board.getBtotalrating();
			getRating.setMidrating(board.getBtotalrating());
			board.setBtotalrating(totalRating);
			board.setBratingcount(getBoard.getBratingcount());
			boardService.updateRatingByBno(board);
			boardService.updateRatingByBnoAndMid(getRating);
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		}else {
			return "redirect:/board/detail.do?cno=-1&bno=" + board.getBno();
		}
	}
}
