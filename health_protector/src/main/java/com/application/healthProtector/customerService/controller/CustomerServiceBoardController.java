package com.application.healthProtector.customerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.healthProtector.customerService.dto.CustomerServiceBoardDTO;
import com.application.healthProtector.customerService.dto.CustomerServiceCommentDTO;
import com.application.healthProtector.customerService.service.CustomerServiceBoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customerService")
public class CustomerServiceBoardController {
	
	@Autowired
	private CustomerServiceBoardService customerServiceBoardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		model.addAttribute("boardList", customerServiceBoardService.getBoardList());
		
		return "customerService/boardList";
	}
	
	@GetMapping("/createBoard")
	public String createBoard() {
		return "customerService/createBoard";
	}
	
	@PostMapping("/createBoard")
	public String createBoard(@ModelAttribute CustomerServiceBoardDTO customerServiceBoardDTO, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		customerServiceBoardDTO.setMemberId(memberId);
		
		customerServiceBoardService.createBoard(customerServiceBoardDTO);
		
		return "redirect:boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("serviceId") int serviceId, Model model) {
		
		model.addAttribute("boardDTO", customerServiceBoardService.getBoardDetail(serviceId));
		model.addAttribute("commentList", customerServiceBoardService.getCommentList(serviceId));
		
		return "customerService/boardDetail";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(@RequestParam("serviceId") int serviceId, Model model) {
		
		model.addAttribute("boardDTO", customerServiceBoardService.getBoardDetail(serviceId));
		
		return "customerService/updateBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute CustomerServiceBoardDTO customerServiceBoardDTO) {
		
		customerServiceBoardService.updateBoard(customerServiceBoardDTO);
		
		return "redirect:boardList";
	}
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("serviceId") int serviceId) {
		customerServiceBoardService.deleteBoard(serviceId);
		
	    return "redirect:/customerService/boardList";
	}
	
	@PostMapping("/createComment")
	public String createComment(@ModelAttribute CustomerServiceCommentDTO customerServiceCommentDTO, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		
		customerServiceCommentDTO.setMemberId(memberId);
		
		customerServiceBoardService.createComment(customerServiceCommentDTO);
		
		return "redirect:/customerService/boardDetail?serviceId=" + customerServiceCommentDTO.getServiceId();
	}
	
	// 댓글 삭제
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestParam("serviceCommentId") int serviceCommentId) {
		
		int serviceId = customerServiceBoardService.getServiceIdByCommentId(serviceCommentId);
		
		customerServiceBoardService.deleteComment(serviceCommentId);
		
		return "redirect:/customerService/boardDetail?serviceId=" + serviceId;
	}
	
	// 댓글 수정
	@PostMapping("/updateComment")
	public String updateComment(@RequestParam("serviceCommentId") int serviceCommentId, @ModelAttribute CustomerServiceCommentDTO customerServiceCommentDTO) {
		
		int serviceId = customerServiceBoardService.getServiceIdByCommentId(serviceCommentId);
		
		customerServiceBoardService.updateComment(customerServiceCommentDTO);
		
		return "redirect:/customerService/boardDetail?serviceId=" + serviceId;
	}
	
}
