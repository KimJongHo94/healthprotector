package com.application.healthProtector.product.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	
	private int productId;
	private int brandId;
	private int categoryId;
	private String productName;
	private String description;
	private int price;
	private int stock;
	private String pictureOriginal;
	private String pictureUUID;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	
}
