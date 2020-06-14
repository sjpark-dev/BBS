package com.mycompany.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.project.dao.GoodDao;
import com.mycompany.project.model.Good;

@Service
public class GoodService {
	
	@Autowired
	private GoodDao goodDao;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GoodService.class);
	
	public Good select(Good good) {
		LOGGER.info("실행");
		
		Good DBgood = goodDao.select(good);
				
		return DBgood;
	}

	public void insertGood(Good good) {
		LOGGER.info("실행");
		
		goodDao.insertGood(good);
		
	}

	public void decreaseUp(Good good) {
		LOGGER.info("실행");
		goodDao.decreaseUp(good);
	}

	public void increaseUp(Good good) {
		LOGGER.info("실행");
		goodDao.increaseUp(good);
	}

	public void insertNotGood(Good good) {
		LOGGER.info("실행");
		goodDao.insertNotGood(good);
		
	}

	public void decreaseDown(Good good) {
		LOGGER.info("실행");
		goodDao.decreaseDown(good);
	}

	public void increaseDown(Good good) {
		LOGGER.info("실행");
		goodDao.increaseDown(good);
	}

}
