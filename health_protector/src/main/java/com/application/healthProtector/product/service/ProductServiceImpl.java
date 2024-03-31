package com.application.healthProtector.product.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dao.ProductDAO;
import com.application.healthProtector.product.dto.ProductDTO;

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
}
