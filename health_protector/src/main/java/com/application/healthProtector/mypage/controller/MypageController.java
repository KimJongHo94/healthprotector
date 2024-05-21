package com.application.healthProtector.mypage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.mypage.service.MypageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService mypageService;
	
	@GetMapping("/memberInfo")
	public String memberInfo(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		if (memberId == null) {
			return "redirect:/member/login";
		}
		
		Map<String, Object> memberInfo = mypageService.getMemberInfo(memberId);
		
		if (memberInfo == null || memberInfo.isEmpty()) {
			// 추후 에러페이지 생성되면 경로 변경 예정
			return "redirect:/member/login";
		}
		
		model.addAttribute("memberDTO", mypageService.getMemberInfo(memberId));
		
		return "mypage/memberInfo";
	}
	
	@GetMapping("/verifyIdentity")
	public String verifyIdentity(Model model, @RequestParam("menu") String menu) {
		model.addAttribute("menu", menu);
		return "mypage/verifyIdentity";
	}
	
	@PostMapping("/verifyIdentity")
	@ResponseBody
	public String verifyIdentity(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
		
		String isValidPw = "n";
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		if (mypageService.verifyPassword(memberId, memberDTO)) {
			isValidPw = "y";
		}
		
		return isValidPw;
	}
	
	@GetMapping("/updateMember")
	public String updateMember(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		model.addAttribute("memberDTO", mypageService.getMemberInfo(memberId));
		
		return "mypage/updateMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute MemberDTO memberDTO, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    String loggedInMemberId = (String) session.getAttribute("memberId");
		
	    System.out.println("loggedInMemberId : " + loggedInMemberId);
	    System.out.println("memberDTO.getMemberId() : " + memberDTO.getMemberId());
	    
	    // 수정 권한 확인
	    if (loggedInMemberId != null && loggedInMemberId.equals(memberDTO.getMemberId())) {
	        // 사용자 정보 업데이트 로직
	        mypageService.updateMember(memberDTO);
	        return "redirect:/mypage/memberInfo";
	    } else {
	        // 권한 없음 처리
	        return "redirect:/login"; 
	    }
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		
		mypageService.deleteMember((String)session.getAttribute("memberId"));
		
		session.invalidate();
		
		return "redirect:/";
	}
	
}
