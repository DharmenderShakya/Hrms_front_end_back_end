package com.example.demo.globalException;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User with this username not found in database !!");
		
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
