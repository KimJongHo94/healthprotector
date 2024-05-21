package com.application.healthProtector.customerService.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.healthProtector.customerService.dto.CustomerServiceBoardDTO;
import com.application.healthProtector.customerService.dto.CustomerServiceCommentDTO;

@Mapper
public interface CustomerServiceBoardDAO {

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
