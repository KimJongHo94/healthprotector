package com.application.healthProtector.customerService.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerServiceBoardDTO {
	
	private int serviceId;
	private String memberId;
	private String subject;
	private String content;
	private String status;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
	
}
