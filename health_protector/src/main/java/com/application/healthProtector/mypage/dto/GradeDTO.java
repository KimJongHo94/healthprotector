package com.application.healthProtector.mypage.dto;

import java.util.Date;

import lombok.Data;

@Data
public class GradeDTO {
	
	private int gradeId;
	private String gradeName;
	private String description;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
