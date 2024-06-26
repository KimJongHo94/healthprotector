package com.application.healthProtector.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/registerMember")
	public String registerMember() {
		return "member/registerMember";
	}
	
	@PostMapping("/registerMember")
	public String registerMember(@ModelAttribute MemberDTO memberDTO) {
		
		memberService.createMember(memberDTO);
		
		return "redirect:/";
	}
	
	@PostMapping("/validId")
	@ResponseBody
	public String valid(@RequestParam("memberId") String memberId) {
		return memberService.checkDuplicatedId(memberId);
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
		
		String isValidMember = "n";
		
		if (memberService.login(memberDTO)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberDTO.getMemberId());
			
			isValidMember = "y";
			
		}
		
		return isValidMember;
	}
	
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("memberId", (String)session.getAttribute("memberId"));
		
		return "member/test";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
}
