package com.application.healthProtector.mypage.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.member.dto.MemberDTO;

@Mapper
public interface MypageDAO {

	public Map<String, Object> getMemberInfo(String memberId);

	public String getMemberPw(String memberId);

	public void updateMember(MemberDTO memberDTO);

	public void deleteMember(String memberId);

}
