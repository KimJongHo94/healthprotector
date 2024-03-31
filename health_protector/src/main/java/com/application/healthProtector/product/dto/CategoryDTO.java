package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CategoryDTO {
	
	private int categoryId;
	private String categoryName;
	private String description;
	private String aLevel;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;		
}
