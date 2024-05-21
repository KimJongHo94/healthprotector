package com.application.healthProtector.customerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.healthProtector.customerService.dao.CustomerServiceBoardDAO;
import com.application.healthProtector.customerService.dto.CustomerServiceBoardDTO;
import com.application.healthProtector.customerService.dto.CustomerServiceCommentDTO;

@Service
public class CustomerServiceBoardServiceImpl implements CustomerServiceBoardService {
	
	@Autowired
	private CustomerServiceBoardDAO customerServiceBoardDAO;
	
	@Override
	public List<CustomerServiceBoardDTO> getBoardList() {
		return customerServiceBoardDAO.getBoardList();
	}

	@Override
	public void createBoard(CustomerServiceBoardDTO customerServiceBoardDTO) {
		customerServiceBoardDAO.createBoard(customerServiceBoardDTO);
	}

	@Override
	public CustomerServiceBoardDTO getBoardDetail(int serviceId) {
		return customerServiceBoardDAO.getBoardDetail(serviceId);
	}

	@Override
	public void updateBoard(CustomerServiceBoardDTO customerServiceBoardDTO) {
		customerServiceBoardDAO.updateBoard(customerServiceBoardDTO);
	}

	@Override
	public void deleteBoard(int serviceId) {
		customerServiceBoardDAO.deleteBoard(serviceId);
	}

	@Override
	public void createComment(CustomerServiceCommentDTO customerServiceCommentDTO) {
		customerServiceBoardDAO.createComment(customerServiceCommentDTO);
	}

	@Override
	public List<CustomerServiceCommentDTO> getCommentList(int serviceId) {
		return customerServiceBoardDAO.getCommentList(serviceId);
	}

	@Override
	public int getServiceIdByCommentId(int serviceCommentId) {
		return customerServiceBoardDAO.getServiceIdByCommentId(serviceCommentId);
	}

	@Override
	public void deleteComment(int serviceCommentId) {
		customerServiceBoardDAO.deleteComment(serviceCommentId);
	}

	@Override
	public void updateComment(CustomerServiceCommentDTO customerServiceCommentDTO) {
		customerServiceBoardDAO.updateComment(customerServiceCommentDTO);
	}

}
