package com.mycompany.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.project.dao.BoardDao;
import com.mycompany.project.model.Board;
import com.mycompany.project.model.Rating;

@Service
public class BoardService {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardDao boardDao;
	
	public void write(Board board) {
		LOGGER.info("실행");
		boardDao.insert(board);
	}
	
	public void insertRating(Rating rating) {
		LOGGER.info("실행");
		boardDao.insertRating(rating);
	}
	
	public Board getBoard(int bno) {
		LOGGER.info("실행");
		Board board = boardDao.selectByBno(bno);
		return board;
	}
	
	public List<Board> getList(){
		List<Board> list = boardDao.selectAll();
		return list;
	}

	public void deleteBoard(int bno) {
		boardDao.deleteByBno(bno);
	}
	
	public void updateByBno(Board board) {
		boardDao.updateByBno(board);
	}
	
	public void updateRatingByBno(Board board) {
		boardDao.updateRatingByBno(board);
	}

	public Rating getRating(int bno, String mid) {
		LOGGER.info("실행");
		Rating rating = boardDao.getRatingByBnoAndMid(bno, mid);
		return rating;
	}
	
	public void deleteRatingByBnoAndMid(int bno, String mid) {
		boardDao.deleteRatingByBnoAndMid(bno, mid);
	}

	public void updateRatingByBnoAndMid(Rating rating) {
		boardDao.updateRatingByBnoAndMid(rating);
	}
	
	public void updateBhitcountByBno(int bno) {
		boardDao.updateBhitcountByBno(bno);
	}
}
