package com.mycompany.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.project.model.Member;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class MemberDao extends EgovAbstractMapper {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MemberDao.class);
	
	public int insert(Member member) {
		LOGGER.info("실행");
		int rows = insert("member.insert", member);
		return rows;
	}
	
	public Member selectByMid(String mid) {
		LOGGER.info("실행");
		Member member = selectOne("member.selectByMid", mid);
		return member;
	}
	public void updateByMid(Member member) {
		LOGGER.info("실행");
		int rows = update("member.updateByMid", member);
	}

	public void deleteByMid(String mid) {
		LOGGER.info("실행");
		int rows = delete("member.deleteByMid", mid);
	}

	public String selectByMnameAndMtel(Member member) {
		LOGGER.info("실행");
		LOGGER.info(member.getMname());
		LOGGER.info(member.getMtel());
		String mid = selectOne("member.selectByMnameAndMtel", member);
		LOGGER.info(mid);
		return mid;
	}

	public String selectByEverything(Member member) {
		LOGGER.info("실행");
		String mpassword = selectOne("member.selectByEverything", member);
		LOGGER.info(mpassword);
		return mpassword;
	}
}
