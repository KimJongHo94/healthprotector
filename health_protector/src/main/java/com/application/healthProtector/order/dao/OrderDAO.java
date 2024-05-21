package com.application.healthProtector.order.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.order.dto.OrderDTO;
import com.application.healthProtector.order.dto.OrderDetailDTO;

@Mapper
public interface OrderDAO {

	public MemberDTO getOrderMemberInfo(String memberId);

	public List<Map<String, Object>> getOrderInfo(String memberId);

	public void saveOrder(OrderDTO orderDTO);

	public void saveOrderDetail(OrderDetailDTO detail);

	public void calculateStock(OrderDetailDTO detail);

	public void orderedCart(String memberId);


}
