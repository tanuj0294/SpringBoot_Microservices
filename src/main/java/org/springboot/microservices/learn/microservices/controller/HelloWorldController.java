package org.springboot.microservices.learn.microservices.controller;

import org.springboot.microservices.learn.microservices.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(path="/helloWorld",method=RequestMethod.GET)
	public String helloWorld() {
		return "hello world !!";
	}
	
	
	@GetMapping(path="/helloWorld/{id}")
	public String helloWorld(@PathVariable(name="id") String iid) {
		return "hello world !!"+iid;
	}
	
	@RequestMapping(path="/helloWorldBean",method=RequestMethod.GET)
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("name1",22);
	}

}
