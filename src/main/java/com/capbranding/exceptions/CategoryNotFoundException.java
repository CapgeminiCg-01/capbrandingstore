package com.capbranding.exceptions;

public class CategoryNotFoundException extends RuntimeException {
	String msg;
	
	public CategoryNotFoundException(String msg){
		this.msg=msg;
	}
	
    @Override
    public String getMessage(){
    	return msg;
    }

}
