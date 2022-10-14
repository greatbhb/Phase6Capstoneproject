package com.aadhaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhaar.bean.AadhaarInfo;
import com.aadhaar.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminContoller {
	@Autowired
	AdminService as;
	
	
	@GetMapping(value ="request")
	public List<AadhaarInfo> request( )
	{
		
		return as.getAllRequest();
		
	}
	
	@GetMapping(value ="duplicate")
	public List<AadhaarInfo> duplicate( )
	{
		
		return as.getAllDuplicate();
		
	}
	@GetMapping(value ="all")
	public List<AadhaarInfo> all( )
	{
		
		return as.getAll();
		
	}
	
	@PatchMapping(value="update")
	public String update(@RequestBody AadhaarInfo email) {
		
		System.out.println(email.getEmailid());
		return as.update(email.getEmailid(), email.getStatus());
	}
	
	@PatchMapping(value="delete/{email}")
	public String delete(@PathVariable("email") String email) {
		
		System.out.println(email);
		
		return as.delete(email);
	}
	
	

}
