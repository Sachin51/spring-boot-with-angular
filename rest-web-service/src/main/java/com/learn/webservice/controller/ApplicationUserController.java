package com.learn.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.webservice.model.ApplicationUser;
import com.learn.webservice.repo.ApplicationUserRepo;
import com.learn.webservice.service.ApplicationUserService;


@RestController
public class ApplicationUserController {
	
	@Autowired
	private ApplicationUserRepo applicationUserRepo; 
	
	@Autowired
	ApplicationUserService userService;
	
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public ApplicationUserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	

	@PostMapping("/signup")
	public ApplicationUser signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userService.save(user);
	}
}
