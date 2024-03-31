package com.application.healthProtector.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.healthProtector.member.dao.MemberDAO;
import com.application.healthProtector.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public void createMember(MemberDTO memberDTO) {
		
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		
		memberDAO.createMember(memberDTO);
	}

	@Override
	public String checkDuplicatedId(String memberId) {
		
		String isValidId = "y";
		
		if (memberDAO.selectDuplicatedId(memberId) != null) {
			isValidId = "n";
		}
		
		return isValidId;
	}

	@Override
	public boolean login(MemberDTO memberDTO) {
		
		MemberDTO validateData = memberDAO.login(memberDTO.getMemberId());
		
		if (validateData != null) {
			if (passwordEncoder.matches(memberDTO.getPassword(), validateData.getPassword()) && !validateData.getActiveYn().equals("n")) {
				return true;
			}
		}
		return false;
	}

}
