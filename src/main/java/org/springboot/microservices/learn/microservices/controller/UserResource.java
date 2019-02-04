package org.springboot.microservices.learn.microservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springboot.microservices.learn.exception.UserNotFoundException;
import org.springboot.microservices.learn.microservices.dao.UserDaoService;
import org.springboot.microservices.learn.microservices.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userService;
	
	@GetMapping(value="/users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value="id") Integer userId) throws UserNotFoundException {
		User user = userService.findOne(userId);
		if(user == null) {
			throw new UserNotFoundException("User not found with id="+userId);
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Validated @RequestBody User user) {
		userService.save(user);
		
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").path("/{name}").buildAndExpand(user.getId(), user.getName()).toUri();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable(value="id") int userId) throws UserNotFoundException {
		User user = userService.deleteUserById(userId);
		
		if(user == null)
			throw new UserNotFoundException("no user found for deletion with id = "+userId);
		
		
	}
}
