package org.springboot.microservices.learn.microservices.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springboot.microservices.learn.exception.UserNotFoundException;
import org.springboot.microservices.learn.microservices.dao.UserDaoService;
import org.springboot.microservices.learn.microservices.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> getUserById(@PathVariable(value = "id") Integer userId,
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) throws UserNotFoundException {
		User user = userService.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User not found with id=" + userId);
		}
		//TODO : Work in i18n
		/*System.out.println("TTT"+locale);
		String greeting = messageSource.getMessage("hello", null, locale);
		System.out.println(greeting);*/
		// implementing HATEOAS for User by building a resource and returning it
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		userService.save(user);

		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").path("/{name}").buildAndExpand(user.getId(),
		// user.getName()).toUri();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable(value = "id") int userId) throws UserNotFoundException {
		User user = userService.deleteUserById(userId);

		if (user == null)
			throw new UserNotFoundException("no user found for deletion with id = " + userId);

	}
}
