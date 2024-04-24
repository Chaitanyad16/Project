package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public void implementRegistration(User user) {
		userRepo.save(user);
	}

	public boolean authenticate(String phone, String pwd) {
		List<User> user = userRepo.findByPhoneNumberAndPassword(phone, pwd);
		return user.size()==1;
	}
}
