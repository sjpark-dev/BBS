package com.mycompany.project.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.project.model.Comment;
import com.mycompany.project.service.CommentService;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class CommentDao extends EgovAbstractMapper{

	public static final Logger LOGGER = LoggerFactory.getLogger(CommentDao.class);
	
	public int write(Comment comment) {
		LOGGER.info("실행");
		int rows = insert("comment.insert", comment);
		return rows;
	}

	public List<Comment> list(int bno) {
		LOGGER.info("실행");
		List<Comment> commentList = selectList("comment.selectCommentsByBno", bno);
		return commentList;
	}

	public int delete(int cno) {
		int rows = delete("comment.deleteByCno", cno);
		return rows;
		
	}

	public void update(Comment comment) {
		LOGGER.info("실행");
		update("comment.updateComment", comment);
	}

	public void increaseUp(int cno) {
		LOGGER.info("실행");
		update("comment.increaseLike", cno);
	}

	public void decreaseUp(int cno) {
		LOGGER.info("실행");
		update("comment.decreaseLike", cno);
		
	}

	public Comment select(int cno) {
		LOGGER.info("실행");
		Comment DBcomment = selectOne("comment.selectByCno", cno);
		return DBcomment;
	}

	public void increaseDown(int cno) {
		LOGGER.info("실행");
		update("comment.increaseUnLike", cno);
		
	}

	public void decreaseDown(int cno) {
		LOGGER.info("실행");
		update("comment.decreaseUnLike", cno);
	}
	
}
