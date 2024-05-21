package com.application.healthProtector.order.service;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.healthProtector.member.dto.MemberDTO;
import com.application.healthProtector.order.dao.OrderDAO;
import com.application.healthProtector.order.dto.OrderDTO;
import com.application.healthProtector.order.dto.OrderDetailDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public MemberDTO getOrderMemberInfo(String memberId) {
		return orderDAO.getOrderMemberInfo(memberId);
	}

	@Override
	public List<Map<String, Object>> getOrderInfo(String memberId) {
		return orderDAO.getOrderInfo(memberId);
	}

	@Override
	public int calculateTotalAmount(List<Map<String, Object>> orderInfo) {
        OptionalInt totalAmount = orderInfo.stream()
            .mapToInt(item -> {
                int price = (Integer)item.get("price");
                Integer quantity = (Integer) item.get("quantity");
                
                return price * quantity;
            })
            .reduce(Integer::sum); 

        return totalAmount.orElse(0);
	}

	@Override
	public void processOrder(OrderDTO orderDTO, List<OrderDetailDTO> orderDetails, String memberId) {
		
		orderDAO.saveOrder(orderDTO);
		
		int orderId = orderDTO.getOrderId();
		
		for (OrderDetailDTO detail : orderDetails) {
	        detail.setOrderId(orderId);
	        orderDAO.saveOrderDetail(detail);
	        orderDAO.calculateStock(detail);	// PRODUCT테이블 재고 수량 구매한 수량 만큼 마이너스
	    }
		
		orderDAO.orderedCart(memberId);
	}

}
