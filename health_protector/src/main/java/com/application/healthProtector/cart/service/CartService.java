package com.application.healthProtector.cart.service;

import java.util.List;
import java.util.Map;

import com.application.healthProtector.cart.dto.CartDTO;

public interface CartService {

	public void addCart(CartDTO cartItem);

	public List<Map<String, Object>> getCartListByMemberId(String memberId);

	public boolean removeItem(int cartId);

	public boolean checkProduct(String memberId, int productId);

}
