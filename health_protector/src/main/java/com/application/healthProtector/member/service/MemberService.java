package com.application.healthProtector.member.service;

import com.application.healthProtector.member.dto.MemberDTO;

public interface MemberService {

	public void createMember(MemberDTO memberDTO);

	public String checkDuplicatedId(String memberId);

}
