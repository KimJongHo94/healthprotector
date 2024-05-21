package com.application.healthProtector.product.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.application.healthProtector.product.dto.ProductDTO;
import com.application.healthProtector.product.dto.ReviewDTO;
import com.application.healthProtector.product.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${file.repo.path}")
    private String fileRepositoryPath;
	
	@GetMapping("/registerProduct")
	public String registerProduct() {
		return "product/registerProduct";
	}
	
	@PostMapping("/registerProduct")
	public String registerProduct(@RequestParam("uploadProduct") MultipartFile uploadProduct, @ModelAttribute ProductDTO productDTO) throws IllegalStateException, IOException {
		
		productService.createProduct(uploadProduct, productDTO);
		
		return "product/registerProduct";
	}
	
	@GetMapping("/productList")
	public String productList(Model model) {
		
		model.addAttribute("productList", productService.getProductList());
		
		return "product/productList";
	}
	
	@GetMapping("/productDetail")
	public String productDetail(Model model, @RequestParam("productId") int productId) {
		
		model.addAttribute("productDetail", productService.getProductDetail(productId));
		
		return "product/productDetail";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(Model model, @RequestParam("productId") int productId) {
		
		model.addAttribute("productDetail", productService.getProductDetail(productId));
		
		return "product/updateProduct";
	}
	
	@GetMapping("/shopProductList")
	public String shopProductList(Model model) {
		
		model.addAttribute("productList", productService.getProductList());
		
		return "shop/shopProductList";
	}
	
	@GetMapping("/shopProductDetail")
	public String shopProductDetail(Model model, @RequestParam("productId") int productId) {
	
		model.addAttribute("productDTO", productService.getProductDetail(productId));
		model.addAttribute("reviewList", productService.getReviewList(productId));
		
		return "shop/shopProductDetail";
	}
	
	/* 상품 리뷰 댓글 */
	@PostMapping("/createReview")
	public String createReview(@RequestParam("uploadReview") MultipartFile uploadReview, 
			                   @ModelAttribute ReviewDTO reviewDTO, 
			                   @RequestParam("productId") int productId,
			                   HttpSession session) throws IllegalStateException, IOException {
		
		reviewDTO.setMemberId((String)session.getAttribute("memberId"));
		
		productService.createReview(uploadReview, reviewDTO);
		
		return "redirect:/product/shopProductDetail?productId=" + productId;
	}
	
	@GetMapping("/thumbnails")
    @ResponseBody
    public Resource thumbnails(@RequestParam("fileName") String fileName) throws IOException{
        return new UrlResource("file:" + fileRepositoryPath + "review/" + fileName);
    }
	
	@PostMapping("/deleteReview")
	public String deleteReview(@RequestParam("reviewId") int reviewId) {
		
		int productId = productService.getProductIdByReviewId(reviewId);
		
		productService.deleteReview(reviewId);
		
		return "redirect:/product/shopProductDetail?productId=" + productId;
	}
	
	@PostMapping("/updateReview")
	public String updateReview(@RequestParam("reviewId") int reviewId, 
			                   @RequestParam("uploadReview") MultipartFile uploadReview,
			                   @ModelAttribute ReviewDTO reviewDTO,
			                   HttpSession session) throws IllegalStateException, IOException {
		
		int productId = productService.getProductIdByReviewId(reviewId);
		
		reviewDTO.setMemberId((String)session.getAttribute("memberId"));
		
		productService.updateReview(uploadReview, reviewDTO);
		
		return "redirect:/product/shopProductDetail?productId=" + productId;
	}
	
}
