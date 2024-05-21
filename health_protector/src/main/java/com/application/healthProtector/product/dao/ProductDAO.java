package com.application.healthProtector.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.dto.ReviewDTO;

@Mapper
public interface ProductDAO {

	public void createProduct(ProductDTO productDTO);

	public List<Map<String, Object>> selectProductList();

	public Map<String, Object> getProductDetail(int productId);

	public void createReview(ReviewDTO reviewDTO);

	public List<Map<String, Object>> getReviewList(int productId);

	public int getProductIdByReviewId(int reviewId);

	public void deleteReview(int reviewId);

	public void updateReview(ReviewDTO reviewDTO);

	public ProductDTO getProductById(int productId);

}
