package com.capbranding.exceptions;

public class OrderNotFoundException extends RuntimeException {
	
	String msg;
	
	public OrderNotFoundException(String msg){
		this.msg=msg;
	}
	
    @Override
    public String getMessage() {
    	return msg;
    }

}