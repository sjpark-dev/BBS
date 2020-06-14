package com.mycompany.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.project.model.Board;
import com.mycompany.project.model.Rating;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDao extends EgovAbstractMapper {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BoardDao.class);
	
	public int insert(Board board) {
		LOGGER.info("실행");
		int rows = insert("board.insert", board);
		return rows;
	}
	
	public int insertRating(Rating rating) {
		LOGGER.info("실행");
		int rows = insert("rating.insert", rating);
		return rows;
	}
	
	public Board selectByBno(int bno) {
		LOGGER.info("실행");
		Board board = selectOne("board.selectByBno", bno);
		return board;
	}
	
	public List<Board> selectAll(){
		List<Board> list = selectList("board.selectAll");
		return list;
	}
	public void deleteByBno(int bno) {
		int rows = delete("board.deleteByBno", bno);
	}
	
	public void updateByBno(Board board) {
		int rows = update("board.updateByBno", board);
	}
	
	public void updateRatingByBno(Board board) {
		int rows = update("board.updateRatingByBno", board);
	}

	public Rating getRatingByBnoAndMid(int bno, String mid) {
		LOGGER.info("실행");
		String bno2 = String.valueOf(bno);
		Map<String, String> abc = new HashMap<>();
		abc.put("bno", bno2);
		abc.put("mid", mid);
		Rating rating = selectOne("rating.selectByBnoAndMid", abc);
		return rating;
	}
	
	public void deleteRatingByBnoAndMid(int bno, String mid) {
		LOGGER.info("실행");
		String bno2 = String.valueOf(bno);
		Map<String, String> abc = new HashMap<>();
		abc.put("bno", bno2);
		abc.put("mid", mid);
		int rows = delete("rating.deleteratingByBnoAndMid", abc);
	}

	public void updateRatingByBnoAndMid(Rating rating) {
		LOGGER.info("실행");
		int rows = update("rating.updateRatingByBnoAndMid", rating);
		
	}
	
	public void updateBhitcountByBno(int bno) {
		int rows = update("updateBhitcountByBno", bno);
	}
	
}
