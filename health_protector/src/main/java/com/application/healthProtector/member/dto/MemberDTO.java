package com.application.healthProtector.member.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String memberId;
	private String password;
	private String name;
	private String email;
	private String phoneNumber;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private String roleGbn;
	private Date createDate;
	private Date updateDate;
	private Date ActiveModDate;
	private Date activeYn;
	
}
