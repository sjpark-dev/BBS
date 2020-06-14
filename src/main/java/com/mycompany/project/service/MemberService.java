 package com.mycompany.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.project.dao.MemberDao;
import com.mycompany.project.model.Member;

@Service
public class MemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberDao;

	public void join(Member member) {
		memberDao.insert(member);
	}
	
	public static final int LOGIN_FAIL_MID = 0;
	public static final int LOGIN_FAIL_MPASSWORD = 1;
	public static final int LOGIN_SUCCESS = 2;
	public int login(Member member) {
		Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember == null) {
			return LOGIN_FAIL_MID;
		} else {
			if(dbMember.getMpassword().equals(member.getMpassword())) {
				return LOGIN_SUCCESS;
			} else {
				return LOGIN_FAIL_MPASSWORD;
			}
		}
	}
	
	public Member selectMember(String mid) {
		LOGGER.info("실행");
		Member member = memberDao.selectByMid(mid);
		return member;
	}
	
	public void myAccountUpdate(Member member) {
		LOGGER.info("실행");
		LOGGER.info(member.getMid());
		memberDao.updateByMid(member);
	}
	
	public void deleteAccount(String mid) {
		LOGGER.info("실행");
		memberDao.deleteByMid(mid);
	}
	
	public String findId(Member member) {
		LOGGER.info("실행");
		String mid = memberDao.selectByMnameAndMtel(member);
		return mid;
	}
	
	public String findPassword(Member member) {
		LOGGER.info("실행");
		String mpassword = memberDao.selectByEverything(member);
		return mpassword;
	}
}