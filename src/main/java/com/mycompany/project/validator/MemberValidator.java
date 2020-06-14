package com.mycompany.project.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycompany.project.model.Member;

@Component
public class MemberValidator implements Validator {
	private static final Logger LOGGER= 
			LoggerFactory.getLogger(MemberValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		LOGGER.info("실행");
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOGGER.info("실행");
		Member member = (Member) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "mid", "errors.mid.required");
		
		if(member.getMname() == null || member.getMname().equals("")) {
			errors.rejectValue("mname", "errors.mname.required");
			LOGGER.info("실행1");
		}
		
		if(!checkIdPw(member.getMid())) {
			errors.rejectValue("mid", "errors.mid.wrongformat");
			LOGGER.info("실행2");
		}
		
		if(!checkIdPw(member.getMpassword())) {
			errors.rejectValue("mpassword", "errors.mpassword.wrongformat");
			LOGGER.info("실행3");
		}
		
		if(member.getMid() != null && !member.getMid().equals("") && member.getMid().length()<5) {
			errors.rejectValue("mid", "errors.mid.minlength");
			LOGGER.info("실행4");
		}
		
		if(member.getMpassword() == null || member.getMpassword().equals("")) {
			errors.rejectValue("mpassword", "errors.mpassword.required");
			LOGGER.info("실행5");
		}
		
		if(member.getMpassword() != null && !member.getMpassword().equals("") && member.getMpassword().length()<8) {
			errors.rejectValue("mpassword", "errors.mpassword.minlength");
			LOGGER.info("실행6");
		}
		
		if(!checkTel(member.getMtel())) {
			errors.rejectValue("mtel", "errors.mtel.wrongformat");
			LOGGER.info("실행7");
		}
		
		if(checkTel(member.getMtel()) && member.getMtel().length()!=11) {
			errors.rejectValue("mtel", "errors.mtel.length");
			LOGGER.info("실행8");
		}
		
		if(!checkEmail(member.getMemail())) {
			errors.rejectValue("memail", "errors.memail.wrongformat");
			errors.rejectValue("memail", "errors.memail.example");
			LOGGER.info("실행9");
		}
		
		if(member.getMname() != null && !member.getMname().equals("") && !checkName(member.getMname())) {
			errors.rejectValue("mname", "errors.mname.wrongformat");
			LOGGER.info("실행10");
		}
	}
	
	public boolean checkIdPw(String idpw) {
		LOGGER.info("실행");
		boolean result = true;
		char[] check = idpw.toCharArray();
		for(int i=0; i<check.length; i++) {
			if(!(check[i] >= 48 && check[i] <=57) && !(check[i] >= 97 && check[i] <=122) && 
			   !(check[i] >= 65 && check[i] <=90)) {
				result = false;
			}
		}
		return result;
	}
	
	public boolean checkEmail(String email) {
		LOGGER.info("실행");
		String[] checkall = email.split("@");
		if(checkall.length != 2) return false;
		char[] check = checkall[0].toCharArray();
		for(int i=0; i<check.length; i++) {
			if(!(check[i] >= 48 && check[i] <=57) && !(check[i] >= 97 && check[i] <=122) && 
			   !(check[i] >= 65 && check[i] <=90)) {
				return false;
			}
		}
		String[] suffix = checkall[1].split("\\.");
		if(suffix.length != 2 && suffix.length != 3) return false;
		for(int j=0; j<suffix.length; j++) {
			char[] check2 = suffix[j].toCharArray();
			for(int i=0; i<check2.length; i++) {
				if(!(check2[i] >= 97 && check2[i] <=122) && 
				   !(check2[i] >= 65 && check2[i] <=90)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkTel(String tel) {
		LOGGER.info("실행");
		boolean result = true;
		char[] check = tel.toCharArray();
		for(int i=0; i<check.length; i++) {
			if(!(check[i] >= 48 && check[i] <=57)) {
				result = false;
			}
		}
		return result;
	}
	
	public boolean checkName(String name) {
		LOGGER.info("실행");
		boolean result = true;
		String korean = "^[가-힣]$*";
		String[] characters = name.split("");
		System.out.println(characters);
		for(int i=0; i<characters.length; i++) {
			if(!characters[i].matches(korean)) {
				result = false;
			}	
		}
		return result;
	}
}
