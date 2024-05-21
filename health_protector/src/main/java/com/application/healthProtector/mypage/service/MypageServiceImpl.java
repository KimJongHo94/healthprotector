package com.application.healthProtector.mypage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.mypage.dao.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Map<String, Object> getMemberInfo(String memberId) {
		return mypageDAO.getMemberInfo(memberId);
	}

	@Override
	public boolean verifyPassword(String memberId, MemberDTO memberDTO) {
		
		if (passwordEncoder.matches(memberDTO.getPassword(), mypageDAO.getMemberPw(memberId))) {
			return true;
		}
		
		return false;
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		
		String memberPw = mypageDAO.getMemberPw(memberDTO.getMemberId());
		
		if (memberPw != null && !passwordEncoder.matches(memberDTO.getPassword(), memberPw)) {
			memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		}
		
		mypageDAO.updateMember(memberDTO);
		
	}

	@Override
	public void deleteMember(String memberId) {
		mypageDAO.deleteMember(memberId);
	}

}
