package com.mycompany.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.project.model.Comment;
import com.mycompany.project.service.BoardService;
import com.mycompany.project.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/write.do")
	public String write( int bno, String bwriter, Comment comment) {
		LOGGER.info("실행");
		LOGGER.info("bno:{}",bno);
		LOGGER.info("ccontent:{}",comment.getCcontent());
	
		comment.setBoard_bno(bno);
		comment.setCwriter(bwriter);
		commentService.write(comment);
		
		return "redirect:/comment/commentList.do?bno="+bno;
	}
	
	@RequestMapping("/commentList.do")
	public String commentList(int bno, Model model) {
		LOGGER.info("실행");
		
		List<Comment> commentList = commentService.list(bno);
		model.addAttribute("commentList", commentList);
		model.addAttribute("bno", bno);
		
		return "comment/commentList";
	}
	
	@PostMapping("/commentListUpdateForm.do")
	public String commentListUpdateForm(int bno,int cno, Model model) {
		LOGGER.info("실행");
		List<Comment> commentList = commentService.list(bno);
		model.addAttribute("commentList", commentList);
		model.addAttribute("bno", bno);
		model.addAttribute("cno", cno);
		
		return "comment/commentListUpdateForm";
	}
	
	@GetMapping("/updateForm.do")
	public String updateForm(int bno, int cno, HttpSession httpSession) {
		LOGGER.info("실행");
		httpSession.setAttribute("updateStatus", "ok");
		return "redirect:/board/detail.do?bno="+bno+"&cno="+cno;
	}
	
	@PostMapping("/update.do")
	public String update(Comment comment,int bno, Model model, HttpSession httpSession ) {
		LOGGER.info("실행");
		LOGGER.info("ccontent:{}", comment.getCcontent());
		commentService.update(comment);
		List<Comment> commentList = commentService.list(bno);
		model.addAttribute("commentList", commentList);
		model.addAttribute("bno", bno);
		httpSession.setAttribute("updateStatus", null);
		
		return "redirect:/board/detail.do?bno="+bno+"&cno=-1";
	}
	
	@GetMapping("/delete.do")
	public String update(int cno, int bno) {
		LOGGER.info("실행");
		
		commentService.delete(cno);
		
		return "redirect:/board/detail.do?bno="+bno+"&cno="+cno;
	}
	
}
