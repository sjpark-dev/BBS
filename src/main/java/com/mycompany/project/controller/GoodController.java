package com.mycompany.project.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.project.model.Good;
import com.mycompany.project.service.CommentService;
import com.mycompany.project.service.GoodService;

@Controller
public class GoodController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private GoodService goodService;
	
	
	@GetMapping("/good.do")
	public String like(Good good, int bno){
		
		LOGGER.info("실행");
		LOGGER.info(good.getMid()+"gdg");
		//과거 좋아요 여부 탐색
		Good DBgood = goodService.select(good);
		
		if(DBgood == null) {
			goodService.insertGood(good);
			//해당 댓글 좋아요 하나 증가
			commentService.increaseUp(good.getCno());
		}
		else {
			//좋아요가 1인지 0 인지 구분
			if(DBgood.getUp() == 1) {
				goodService.decreaseUp(good);
				commentService.decreaseUp(good.getCno());
			}
			else if(DBgood.getUp() == 0){
				goodService.increaseUp(good);
				commentService.increaseUp(good.getCno());
			}	
		}
		return "redirect:/board/detail.do?bno="+bno+"&cno=-1";
	}
	
	@GetMapping("/notGood.do")
	public String unLike(Good good, int bno){
		
		LOGGER.info("실행");
		//과거 싫어요 여부 탐색
		Good DBgood = goodService.select(good);
		
		
		if(DBgood == null) {
			goodService.insertNotGood(good);
			//해당 댓글 싫어요 하나 증가
			commentService.increaseDown(good.getCno());
		}
		else {
			//싫어요가 1인지 0 인지 구분
			if(DBgood.getDown() == 1) {
				goodService.decreaseDown(good);
				commentService.decreaseDown(good.getCno());
			}
			else if(DBgood.getDown() == 0){
				goodService.increaseDown(good);
				commentService.increaseDown(good.getCno());
			}	
		}
		return "redirect:/board/detail.do?bno="+bno+"&cno=-1";
	}
	
}
