package com.mycompany.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.project.model.Good;
import com.mycompany.project.service.GoodService;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class GoodDao extends EgovAbstractMapper{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GoodDao.class);

	public Good select(Good good) {
		LOGGER.info("실행");
		
		Good DBgood= selectOne("good.selectByCnoAndMid", good);
		return DBgood;
	}

	public void insertGood(Good good) {
		LOGGER.info("실행");
		insert("good.insertGood", good);
	}

	public void decreaseUp(Good good) {
		LOGGER.info("실행");
		update("good.decreaseUp", good);
		
	}

	public void increaseUp(Good good) {
		LOGGER.info("실행");
		update("good.increaseUp", good);
		
	}

	public void insertNotGood(Good good) {
		LOGGER.info("실행");
		insert("good.insertNotGood", good);
		
	}

	public void decreaseDown(Good good) {
		LOGGER.info("실행");
		update("good.decreaseDown", good);
		
	}

	public void increaseDown(Good good) {
		LOGGER.info("실행");
		update("good.increaseDown", good);
		
	}

}
