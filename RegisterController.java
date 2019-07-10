package com.lti.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.dto.StatusDTO;
import com.lti.training.dto.UserDTO;
import com.lti.training.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(path= "/register", method = RequestMethod.POST)
	public StatusDTO register(@RequestBody UserDTO user) { //to read the (JSON)response correctly that is coming from the request sent by AJAX
		StatusDTO statusDTO =registerService.addUser(user);
		return statusDTO;
	}
	
	@RequestMapping(path= "/fetch", method = RequestMethod.GET)
	public UserDTO fetch(@RequestParam(name = "id") int id) { //to read the (JSON)response correctly that is coming from the request sent by AJAX
		
		return registerService.fetch(id);
	}
}
