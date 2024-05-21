package com.application.healthProtector.customerService.service;

import java.util.List;

import com.application.healthProtector.customerService.dto.CustomerServiceBoardDTO;
import com.application.healthProtector.customerService.dto.CustomerServiceCommentDTO;

public interface CustomerServiceBoardService {
	
	public List<CustomerServiceBoardDTO> getBoardList();

	public void createBoard(CustomerServiceBoardDTO customerServiceBoardDTO);

	public CustomerServiceBoardDTO getBoardDetail(int serviceId);

	public void updateBoard(CustomerServiceBoardDTO customerServiceBoardDTO);

	public void deleteBoard(int serviceId);

	public void createComment(CustomerServiceCommentDTO customerServiceCommentDTO);

	public List<CustomerServiceCommentDTO> getCommentList(int serviceId);

	public int getServiceIdByCommentId(int serviceCommentId);

	public void deleteComment(int serviceCommentId);

	public void updateComment(CustomerServiceCommentDTO customerServiceCommentDTO);

}
