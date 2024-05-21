package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int reviewId;
	private int productId;
	private String memberId;
	private int rating;
	private String content;
	private String pictureOriginal;
	private String pictureUUID;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
