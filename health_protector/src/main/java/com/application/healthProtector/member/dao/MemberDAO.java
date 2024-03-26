package com.application.healthProtector.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public void createMember(MemberDTO memberDTO);

	public String selectDuplicatedId(String memberId);

}
