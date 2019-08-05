package com.learn.webservice.service;

import com.learn.webservice.model.ApplicationUser;

public interface ApplicationUserService {

	ApplicationUser save(ApplicationUser user);
	
	ApplicationUser findByUsername(String username);
}
