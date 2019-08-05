package com.learn.webservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.webservice.model.ApplicationUser;
import com.learn.webservice.repo.ApplicationUserRepo;
import com.learn.webservice.service.ApplicationUserService;

public class ApplicationUserServiceImpl implements ApplicationUserService{

	
	@Autowired
	ApplicationUserRepo userRepo;
	
	@Autowired
	ApplicationUserService userService;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ApplicationUser save(ApplicationUser user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public ApplicationUser findByUsername(String username) {
		return userRepo.findByUserName(username);
	}
}
