package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@GetMapping("register")
	public String Register(@ModelAttribute("user") User user) {
	return "register";
	}

	@PostMapping("register")

	public String makeRegistration(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		userService.implementRegistration(user);
		return "redirect:login";
	}

}


