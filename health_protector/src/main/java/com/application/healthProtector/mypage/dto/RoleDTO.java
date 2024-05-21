package com.application.healthProtector.mypage.dto;

import java.util.Date;

import lombok.Data;

@Data
public class RoleDTO {
	
	private int roleId;
	private String roleName;
	private String description;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
