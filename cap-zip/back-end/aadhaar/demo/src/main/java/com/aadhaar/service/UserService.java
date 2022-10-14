package com.aadhaar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadhaar.bean.User;
import com.aadhaar.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userdb;
	
	public String register(User u)
	{
		Optional<User> result= userdb.findById(u.getEmailid());
		
		if(result.isPresent())
		{
			return "User already present";
		}
		else if(result.get().getPhno().equals(u.getPhno()))
		{
			return "phone number already exist";
		}
		else
		{
				userdb.save(u);
				return "Registered";	
			
		}
	}
	
	public String login(User u)
	{
		Optional<User> result= userdb.findById(u.getEmailid());
		
		if(result.isPresent())
		{
			if(result.get().getEmailid().equals(u.getEmailid())&&result.get().getPassword().equals(u.getPassword()))
			{
//				if(result.get().getRole().equals(u.getRole()))
//				{
//					return result.get().getRole();
//				}
				return "login";
				
			}
			return "invalid credentials";
		}
		
		return "User not present";
	}

}
