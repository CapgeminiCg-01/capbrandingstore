package com.capbranding.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
String msg;
	
	public EmployeeNotFoundException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
		
	}
	

}