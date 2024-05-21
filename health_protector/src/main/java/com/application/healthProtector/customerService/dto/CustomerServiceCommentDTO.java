package com.application.healthProtector.customerService.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerServiceCommentDTO {
	
	private int serviceCommentId;
	private int serviceId;
	private String memberId;
	private String content;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;

}
