package com.ramso.restapi.util;

public class CantReachDatabaseException extends RuntimeException {
	
	public CantReachDatabaseException() {
        super(String.format("Operation couldn't complete. Database may be out of reach."));
    }
}
