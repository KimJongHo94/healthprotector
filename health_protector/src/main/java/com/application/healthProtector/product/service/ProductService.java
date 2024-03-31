package com.application.healthProtector.product.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dto.ProductDTO;

public interface ProductService {

	public void createProduct(MultipartFile uploadProduct, ProductDTO productDTO) throws IllegalStateException, IOException;

}
