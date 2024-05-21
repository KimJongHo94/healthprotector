package com.application.healthProtector.product.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dao.ProductDAO;
import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.dto.ReviewDTO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Value("${file.repo.path}")
    private String fileRepositoryPath;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void createProduct(MultipartFile uploadProduct, ProductDTO productDTO) throws IllegalStateException, IOException {
		
		if (!uploadProduct.isEmpty()) {
			
			String originalFilename = uploadProduct.getOriginalFilename();
			productDTO.setPictureOriginal(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			productDTO.setPictureUUID(uploadFile);
			
			uploadProduct.transferTo(new File(fileRepositoryPath + "product/" + uploadFile));
		}
		
		productDAO.createProduct(productDTO);
	}

	@Override
	public List<Map<String, Object>> getProductList() {
		return productDAO.selectProductList();
	}

	@Override
	public Map<String, Object> getProductDetail(int productId) {
		return productDAO.getProductDetail(productId);
	}

	@Override
	public void createReview(MultipartFile uploadReview, ReviewDTO reviewDTO) throws IllegalStateException, IOException {
		
		if (!uploadReview.isEmpty()) {
			
			String originalFilename = uploadReview.getOriginalFilename();
			reviewDTO.setPictureOriginal(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			reviewDTO.setPictureUUID(uploadFile);
			
			uploadReview.transferTo(new File(fileRepositoryPath + "review/" + uploadFile));
		}
		productDAO.createReview(reviewDTO);
	}

	@Override
	public List<Map<String, Object>> getReviewList(int productId) {
		return productDAO.getReviewList(productId);
	}

	@Override
	public int getProductIdByReviewId(int reviewId) {
		return productDAO.getProductIdByReviewId(reviewId);
	}

	@Override
	public void deleteReview(int reviewId) {
		productDAO.deleteReview(reviewId);
	}

	@Override
	public void updateReview(MultipartFile uploadReview, ReviewDTO reviewDTO) throws IllegalStateException, IOException {
		
		if (!uploadReview.isEmpty()) {
			
			new File(fileRepositoryPath + reviewDTO.getPictureUUID()).delete(); // 기존 UUID 삭제
			
			String originalFilename = uploadReview.getOriginalFilename();
			reviewDTO.setPictureOriginal(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			reviewDTO.setPictureUUID(uploadFile);
			
			uploadReview.transferTo(new File(fileRepositoryPath + "review/" + uploadFile));
		}
		
		productDAO.updateReview(reviewDTO);
		
	}

	@Override
	public ProductDTO getProductById(int productId) {
		return productDAO.getProductById(productId);
	}

	

	
}
