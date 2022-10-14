package com.aadhaar.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhaar.bean.AadhaarInfo;
import com.aadhaar.service.AadhaarService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	AadhaarService as;
	
	@PostMapping(value ="apply",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String apply(@RequestBody AadhaarInfo a)
	{
		System.out.println(a);
			return as.apply(a);
			
	}
	
	@PatchMapping(value="update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody AadhaarInfo a)
	{
		System.out.println(a);
		return as.update(a);
		
	}
	
	@GetMapping(value ="duplicate/{email}")
	public String duplicate(@PathVariable("email") String email )
	{
		System.out.println(email);
		return as.requestDuplicate(email);
		
	}
	
	@GetMapping(value="getinfo/{email}")
	public AadhaarInfo getInfo(@PathVariable("email") String email)
	{
		return as.requestData(email);
	}
	

}
