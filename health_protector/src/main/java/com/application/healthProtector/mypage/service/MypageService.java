package com.application.healthProtector.mypage.service;

import java.util.Map;

import com.application.healthProtector.member.dto.MemberDTO;

public interface MypageService {

	public Map<String, Object> getMemberInfo(String memberId);

	public boolean verifyPassword(String memberId, MemberDTO memberDTO);

	public void updateMember(MemberDTO memberDTO);

	public void deleteMember(String memberId);



}
