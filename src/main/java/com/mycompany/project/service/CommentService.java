package com.mycompany.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.project.dao.CommentDao;
import com.mycompany.project.model.Comment;

@Service
public class CommentService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);
	
	@Autowired
	private CommentDao commentDao;
	
	public void write(Comment comment) {
		LOGGER.info("실행");
		commentDao.write(comment);
	}

	public List<Comment> list(int bno) {
		LOGGER.info("실행");
		List<Comment> commentList = commentDao.list(bno);
		return commentList;
	}

	public void delete(int cno) {
		LOGGER.info("실행");
		commentDao.delete(cno);	
	}

	public void update(Comment comment) {
		LOGGER.info("실행");
		commentDao.update(comment);
		
	}

	public void increaseUp(int cno) {
		LOGGER.info("실행");
		commentDao.increaseUp(cno);
		
	}

	public void decreaseUp(int cno) {
		LOGGER.info("실행");
		commentDao.decreaseUp(cno);
		
	}

	public Comment select(int cno) {
		LOGGER.info("실행");
		Comment DBcomment = commentDao.select(cno);
		return DBcomment;
	}

	public void increaseDown(int cno) {
		LOGGER.info("실행");
		commentDao.increaseDown(cno);
	}

	public void decreaseDown(int cno) {
		LOGGER.info("실행");
		commentDao.decreaseDown(cno);
	}
	
	
}
