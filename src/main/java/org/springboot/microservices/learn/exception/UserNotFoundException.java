package org.springboot.microservices.learn.exception;

//@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1198405219107158498L;

	
	public UserNotFoundException(String message) {
		super(message);
	}
}
