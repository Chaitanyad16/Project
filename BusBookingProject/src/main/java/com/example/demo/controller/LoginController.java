package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.expection.AuthenticationDetailException;
import com.example.demo.service.UserService;

@SessionAttributes({"phoneNumber","bookingDetail"})
@Controller
public class LoginController {

@Autowired
UserService userService;



@GetMapping("login")
public String LoginPage() {
return "login";
}

@PostMapping("login")

public String doLogin(@RequestParam String phone, @RequestParam String pwd, ModelMap model) {
	String view="";
	try {
		if(phone.isBlank()) {
			throw new AuthenticationDetailException("Phone Number is required");
		}
		if(pwd.isBlank()) {
			throw new AuthenticationDetailException("Phone Number is required");
		}
		if(userService.authenticate(phone, pwd)) {
			model.put("phoneNumber", phone);
			view= "redirect:/home";
		}
		else {
			throw new AuthenticationDetailException("Wrong Credentials.");
		}
	}catch(AuthenticationDetailException e) {
		model.put("error", e.getMessage());
		view = "login";
	}
	
	return view;
}


//logout
@GetMapping("/logout")
public String logout(ModelMap model) {
	model.put("phoneNumber", "");
	return "redirect:home";
}

//home
@GetMapping("home")
public String home() {
	return "home";
}


}
