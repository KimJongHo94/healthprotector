package com.application.healthProtector.order.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDetailDTO {
	
	private int orderDetailId;
	private int orderId;
	private int productId;
	private int quantity;
	private int price;
	private Date createDate;
	private Date updateDate;
	
}
