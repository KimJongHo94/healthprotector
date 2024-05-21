package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewCommentDTO {
	
	private int reviewCommentId;
	private int reviewId;
	private String memberId;
	private String content;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
