package com.application.healthProtector.order.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.healthProtector.cart.service.CartService;
import com.application.healthProtector.order.dto.OrderDTO;
import com.application.healthProtector.order.dto.OrderDetailDTO;
import com.application.healthProtector.order.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		List<Map<String, Object>> orderInfo = orderService.getOrderInfo(memberId);
	    int totalPrice = orderService.calculateTotalAmount(orderInfo);
		
		model.addAttribute("memberInfo", orderService.getOrderMemberInfo(memberId));
		model.addAttribute("cartItems", orderInfo);
		model.addAttribute("totalPrice", totalPrice);
		
		
		return "order/checkout";
	}
	
	@PostMapping("/submitOrder")
	public String submitOrder(@ModelAttribute OrderDTO orderDTO, @RequestParam("totalPrice") int totalPrice, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		orderDTO.setMemberId(memberId);
		orderDTO.setTotalPrice(totalPrice);
		
		List<Map<String, Object>> cartItems = cartService.getCartListByMemberId(memberId);
	
		List<OrderDetailDTO> orderDetails = cartItems.stream().map(item -> {
	        OrderDetailDTO detail = new OrderDetailDTO();
	        detail.setProductId((Integer) item.get("productId"));
	        detail.setQuantity((Integer) item.get("quantity"));
	        detail.setPrice((Integer) item.get("price"));
	        
	        return detail;
	        
	    }).collect(Collectors.toList());
		
		orderService.processOrder(orderDTO, orderDetails, memberId);
		
		return "order/thankyou";
	}
	
	@GetMapping("/orderList")
	public String orderList(Model model, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		return "order/orderList";
	}
	
}
