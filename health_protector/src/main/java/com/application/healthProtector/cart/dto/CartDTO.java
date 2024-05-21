package com.application.healthProtector.cart.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	
	private int cartId;
	private String memberId;
	private int productId;
	private int quantity;
	private String status;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
		
}
