package com.aadhaar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadhaar.bean.AadhaarInfo;
import com.aadhaar.repository.AadhaarRepository;

@Service
public class AadhaarService {

	@Autowired
	AadhaarRepository ar;
	public String apply(AadhaarInfo a)
	{
		Optional<AadhaarInfo> result = ar.findById(a.getEmailid());
		if(!result.isPresent())
		{
			ar.save(a);
			return "request Successfull";
		}
		else
		{
			if(result.get().getStatus().equals("approved"))
			{
				return "Aadhaar is Already Present and Active";
			}
			else if(result.get().getStatus().equals("pending"))
			{
				return "Aadhaar is Already Present and Pending";
			}
			else
			{
				ar.save(a);
				return "Previous Request was Cancelled and Requested Again ";
			}
			
		}

		
				
	}
	
	public AadhaarInfo requestData(String email)
	{
		Optional<AadhaarInfo> result = ar.findById(email);
		
		
			return result.get();
	
			
		
		
	}
	
	public String update(AadhaarInfo a)
	{
		if(a!=null)
		{
			
		try {
			ar.saveAndFlush(a);
			return "updated";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "request failed";
		}
		}
			return "request failed";
	
	}
	
	public String delete(AadhaarInfo a)
	{
		try {
			ar.delete(a);
			return "deleted";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
	}
	
	public String requestDuplicate(String email )
	{
		Optional<AadhaarInfo> result = ar.findById(email);
		if(result.isPresent())
		{
			result.get().setStatus("duplicate");
			ar.saveAndFlush(result.get());
			return "Request Successful";
		}
		return "Request failed";
	}
}
