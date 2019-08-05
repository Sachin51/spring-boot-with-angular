package com.learn.webservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.webservice.model.HelloBean;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping(value="/greet/{name}")
	public String getGreet(@PathVariable String name) {
		return "Hello World...!Welcome "+name;
	}
	
	@GetMapping(value="/greeting/{name}")
	public HelloBean getGreeting(@PathVariable String name) {
		//throw new RuntimeException("Something went wrong...Contact Admin....***--***");
		return new HelloBean(name);
	}
	
	@GetMapping(value="/greeting/pathvariable/{name}")
	public HelloBean getGreetingWithPathVariable(@PathVariable String name) {
		return new HelloBean(name);
	}
}
