package com.aadhaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhaar.bean.User;
import com.aadhaar.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	
	@Autowired
	UserService uservice;
	
	@PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody User u)
	{
		System.out.println(u.toString());
		return uservice.register(u);
		
	}
	
	@PostMapping(value="/signin",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody User u)
	{
		System.out.println(u);
		return uservice.login(u);
	}

}
