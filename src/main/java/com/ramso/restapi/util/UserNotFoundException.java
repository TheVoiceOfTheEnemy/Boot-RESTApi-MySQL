package com.ramso.restapi.util;

public class UserNotFoundException extends RuntimeException {
	
	    public UserNotFoundException(String id) {
	        super(String.format("No user found with id: <%s>", id));
	    }
	

}
