package com.lti.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.dao.RegisterDao;
import com.lti.training.dto.StatusDTO;
import com.lti.training.dto.UserDTO;
import com.lti.training.entity.User;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao dao;
	
	@Transactional
	public StatusDTO addUser(UserDTO userDTO){
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setAge(userDTO.getAge());
		user.setDob(userDTO.getDob());
		
		int id =dao.save(user);
		
		StatusDTO statusDTO = new StatusDTO();
		statusDTO.setId(id);
		statusDTO.setMessage("Data inserted");
		
		return statusDTO;
		
	}
	
	public UserDTO fetch(int id) {
		User user = dao.fetch(id);
		
		
		UserDTO dto = new  UserDTO();
		dto.setName(user.getName());
		dto.setDob(user.getDob());
		dto.setEmail(user.getEmail());
		dto.setAge(user.getAge());
		return dto;
	}
}
