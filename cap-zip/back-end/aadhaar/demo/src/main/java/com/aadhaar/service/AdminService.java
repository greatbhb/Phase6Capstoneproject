package com.aadhaar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.aadhaar.bean.AadhaarInfo;
import com.aadhaar.repository.AadhaarRepository;
import com.aadhaar.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	AadhaarRepository ar;
	
	
	public List<AadhaarInfo> getAllRequest()
	{
		return ar.allRequest("pending");
	}
	
	public List<AadhaarInfo> getAllDuplicate()
	{
		return ar.allRequest("duplicate");
	}
	
	public List<AadhaarInfo> getAll()
	{
		return ar.findAll();
	}
	
	public String update(String email,String status)
	{
		Optional<AadhaarInfo> result=ar.findById(email);
		System.out.println("!!!!!!!!!"+email);
		System.out.println();
		try {
			result.get().setStatus(status);
			ar.saveAndFlush(result.get());
			return "Updated";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "Updation failed";
		}
	}
	
	public String delete(String email)
	{
		Optional<AadhaarInfo> result=ar.findById(email);
		
		try {
			ar.delete(result.get());
			return "Deleted";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Delete Unsuccessful";
		}
	}
	
	
}
