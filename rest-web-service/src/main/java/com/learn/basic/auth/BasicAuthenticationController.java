package com.learn.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/auth"})
public class BasicAuthenticationController {

	@GetMapping(value="/basicauth")
	public AuthenticationBean getGreet() {
		System.out.println("working..............");
		return new AuthenticationBean("You are Authenticated.....!");
	}
}
 