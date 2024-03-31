package com.application.healthProtector.product.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/registerProduct")
	public String registerProduct() {
		return "product/registerProduct";
	}
	
	@PostMapping("/registerProduct")
	public String registerProduct(@RequestParam("uploadProduct") MultipartFile uploadProduct, @ModelAttribute ProductDTO productDTO) throws IllegalStateException, IOException {
		
		productService.createProduct(uploadProduct, productDTO);
		
		return "product/registerProduct";
	}
	
}
