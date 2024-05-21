package com.application.healthProtector.order.service;

import java.util.List;
import java.util.Map;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.order.dto.OrderDTO;
import com.application.healthProtector.order.dto.OrderDetailDTO;

public interface OrderService {

	public MemberDTO getOrderMemberInfo(String memberId);

	public List<Map<String, Object>> getOrderInfo(String memberId);

	public int calculateTotalAmount(List<Map<String, Object>> orderInfo);

	public void processOrder(OrderDTO orderDTO, List<OrderDetailDTO> orderDetails, String memberId);
}
