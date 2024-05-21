package com.application.healthProtector.cart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.healthProtector.cart.dto.CartDTO;
import com.application.healthProtector.cart.service.CartService;
import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/checkProduct")
	@ResponseBody
	public boolean checkProduct(@RequestParam("productId") int productId, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		return cartService.checkProduct(memberId, productId);
	}
	
	@PostMapping("/addCart")
	public String addCart(@RequestParam("productId") int productId,
			              @RequestParam("quantity") int quantity,
			              HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		if (memberId == null) {
			return "redirect:/member/login";
		}
		
		try {
			
			ProductDTO product = productService.getProductById(productId);
			
			if (product != null) {
				
				CartDTO cartItem = new CartDTO();
				
				cartItem.setMemberId(memberId);
				cartItem.setProductId(product.getProductId());
				cartItem.setQuantity(quantity);
				
				cartService.addCart(cartItem);
				
				return "redirect:/cart/mainCart";
			}
			else {
				return "redirect:/product/shopProductDetail?productId=" + productId;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "cart/mainCart";
	}
	
	@GetMapping("/mainCart")
	public String memberInfo(Model model, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		
		if (memberId == null) {
			return "redirect:/member/login";
		}
		
		List<Map<String, Object>> cartList = cartService.getCartListByMemberId(memberId);
		
		model.addAttribute("cartList", cartList);
		
		return "cart/mainCart";
	}
	
	@PostMapping("/removeItem")
	@ResponseBody
	public boolean removeItem(@RequestParam("cartId") int cartId) {
		
		boolean isRemoved = cartService.removeItem(cartId);
		
		return isRemoved;
	}
	
}
