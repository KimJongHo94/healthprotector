package com.application.healthProtector.cart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.healthProtector.cart.dao.CartDAO;
import com.application.healthProtector.cart.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void addCart(CartDTO cartItem) {
		cartDAO.addCart(cartItem);
	}

	@Override
	public List<Map<String, Object>> getCartListByMemberId(String memberId) {
		return cartDAO.getCartListByMemberId(memberId);
	}

	@Override
	public boolean removeItem(int cartId) {
		try {
	        cartDAO.removeItem(cartId);
	        return true; 
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean checkProduct(String memberId, int productId) {
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setMemberId(memberId);
		cartDTO.setProductId(productId);
		
		return cartDAO.checkProduct(cartDTO) > 0;
	}

}
