package com.mycompany.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.project.model.Member;
import com.mycompany.project.service.MemberService;
import com.mycompany.project.validator.MemberValidator;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger LOGGER= 
			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberValidator memberValidator;
	
	@InitBinder("member")
	public void initBinderMember(WebDataBinder binder) {
		binder.addValidators(memberValidator);
	}
	
	@GetMapping("/join.do")
	public String joinform(Member member) {
		LOGGER.info("실행");
		return "member/joinForm";
	}
	
	@PostMapping("/join.do")
	public String join(@Valid Member member, BindingResult bindingResult) {
		LOGGER.info("실행");
		Member dBmember = memberService.selectMember(member.getMid());
		if(dBmember != null) {
			bindingResult.rejectValue("mid", "errors.mid.duplicate");
		}
		if(bindingResult.hasErrors()) {	
			LOGGER.info("에러가 있음");
			return "member/joinForm";
		} else {
			memberService.join(member);
			return "redirect:/board/list.do";
		}
	}
	
	@GetMapping("/login.do")
	public String loginForm(Member member, Model model) {
		LOGGER.info("실행");
		member.setMname("더미이름");
		member.setMtel("01012341234");
		member.setMemail("dummy@email.com");
		model.addAttribute("member", member);
		return "member/loginForm";
	}
	
	@PostMapping("/login.do")
	public String login(@Valid Member member, BindingResult bindingResult,
						HttpSession session) {
		LOGGER.info("실행");
		String viewName = "member/loginForm";
		if(bindingResult.hasErrors()) {
			return viewName;
		}
		LOGGER.info(member.getMid() + member.getMpassword());
		int result = memberService.login(member);
		if(result == MemberService.LOGIN_SUCCESS) {
			session.setAttribute("sessionMid", member.getMid());
			viewName = "redirect:/board/list.do";
		} else if(result == MemberService.LOGIN_FAIL_MID) {
			bindingResult.rejectValue("mid", "login.fail.mid");
		} else if(result == MemberService.LOGIN_FAIL_MPASSWORD) {
			bindingResult.rejectValue("mpassword", "login.fail.mpassword");
		}
		return viewName;
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/list.do";
	}
	
	/*@GetMapping("/myAccount.do")
	public String myAccount(HttpSession session, Model model) {
		LOGGER.info("실행");
		String mid = (String) session.getAttribute("sessionMid");
		Member member = memberService.selectMember(mid);
		model.addAttribute("member", member);
		return "member/myAccountForm";
	}*/
	
	@PostMapping("/myAccount.do")
	public String myAccountUpdate(@Valid Member member, BindingResult bindingResult, String mnpassword1, String mnpassword2, HttpSession session) {
		LOGGER.info("실행");
		String viewName = "redirect:/board/list.do";
		if(bindingResult.hasErrors()) {
			viewName="member/myAccountForm";
			return viewName;
		}
		
		String mid = (String) session.getAttribute("sessionMid");
		member.setMid(mid);
		memberService.myAccountUpdate(member);
		return viewName;
	}
	
	@GetMapping("/deleteAccount.do")
	public String deleteAccount(HttpSession session) {
		LOGGER.info("실행");
		String mid = (String) session.getAttribute("sessionMid");
		memberService.deleteAccount(mid);
		session.invalidate();
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/findId.do")
	public String findIdForm(Member member) {
		member.setMid("dummyid");
		member.setMpassword("dummypassword");
		member.setMemail("dummy@email.com");
		LOGGER.info("실행");
		return "member/findIdForm";
	}
	
	@PostMapping("/findId.do")
	public String findId(@Valid Member member, BindingResult bindingResult, Model model) {
		LOGGER.info("실행");
		String viewName = "member/findResult";
		if(bindingResult.hasErrors()) {
			viewName = "member/findIdForm";
			return viewName;
		}
		
		String mid = memberService.findId(member);
		if(mid == null) {
			model.addAttribute("message", "입력한 정보가 잘못되었습니다.");
		} else {
			model.addAttribute("message", "찾으시는 아이디는 [  " + mid + "  ]입니다.");
			model.addAttribute("resulttype", "identification");
		}
		return viewName;
	}
	
	@GetMapping("/findPassword.do")
	public String findPasswordForm(Member member) {
		LOGGER.info("실행");
		member.setMpassword("dummypassword");
		return "member/findPasswordForm";
	}
	
	@PostMapping("/findPassword.do")
	public String findPassword(@Valid Member member, BindingResult bindingResult, Model model) {
		LOGGER.info("실행");
		String viewName = "member/findResult";
		if(bindingResult.hasErrors()) {
			viewName = "member/findPasswordForm";
			return viewName;
		}
		String mpassword = memberService.findPassword(member);
		if(mpassword == null) {
			model.addAttribute("message", "입력한 정보가 잘못되었습니다.");
		} else {
			model.addAttribute("message", "찾으시는 비밀번호는 [  " + mpassword + "  ]입니다.");
		}
		return viewName;
	}
	
	@GetMapping("/gate.do")
	public String gateForm(HttpSession session, Model model){
		LOGGER.info("실행");
		String mid = (String) session.getAttribute("sessionMid");
		Member member = memberService.selectMember(mid);
		member.setMpassword("");
		model.addAttribute("member", member);
		return "member/gateForm";
	}
	
	@PostMapping("/gate.do")
	public String gate(@Valid Member member, BindingResult bindingResult) {
		LOGGER.info("실행");
		String viewName = "member/gateForm";
		
		if(bindingResult.hasErrors()) {
			return viewName;
		}
		
		int result = memberService.login(member);
		if(result == MemberService.LOGIN_SUCCESS) {
			viewName = "member/myAccountForm";
		} else if(result == MemberService.LOGIN_FAIL_MPASSWORD) {
			bindingResult.rejectValue("mpassword", "login.fail.mpassword");
		}
		return viewName;
	}
}