package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BrandDTO {
	
	private int brandId;
	private int brandName;
	private String description;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
}
