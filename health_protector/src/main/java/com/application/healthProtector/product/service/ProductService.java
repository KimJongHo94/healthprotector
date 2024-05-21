package com.application.healthProtector.product.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.dto.ReviewDTO;

public interface ProductService {

	public void createProduct(MultipartFile uploadProduct, ProductDTO productDTO) throws IllegalStateException, IOException;

	public List<Map<String, Object>> getProductList();

	public Map<String, Object> getProductDetail(int productId);

	public void createReview(MultipartFile uploadReview, ReviewDTO reviewDTO) throws IllegalStateException, IOException;

	public List<Map<String, Object>> getReviewList(int productId);

	public int getProductIdByReviewId(int reviewId);

	public void deleteReview(int reviewId);

	public void updateReview(MultipartFile uploadReview, ReviewDTO reviewDTO) throws IllegalStateException, IOException;

	public ProductDTO getProductById(int productId);


}
