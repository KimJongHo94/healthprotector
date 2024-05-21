package com.application.healthProtector.order.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int orderId;
	private String memberId;
	private int totalPrice;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private String orderStatus;
	private String paymentMethod;
	private String customerNote;
	private Date orderDate;
	private Date updateDate;
	
}
