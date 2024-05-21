package com.application.healthProtector.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.cart.dto.CartDTO;

@Mapper
public interface CartDAO {

	public void addCart(CartDTO cartItem);

	public List<Map<String, Object>> getCartListByMemberId(String memberId);

	public boolean removeItem(int cartId);

	public int checkProduct(CartDTO cartDTO);

}
