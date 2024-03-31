package com.application.healthProtector.product.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.product.dto.ProductDTO;

@Mapper
public interface ProductDAO {

	public void createProduct(ProductDTO productDTO);

}
