package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryDetailDTO {
	
	private int categoryDetailId;
	private int categoryId;
	private String categoryDetailName;
	private String description;
	private String bLevel;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
