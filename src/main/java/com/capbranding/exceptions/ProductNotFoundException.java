package com.capbranding.exceptions;

public class ProductNotFoundException extends RuntimeException {
	String msg;
	
	public ProductNotFoundException(String msg) {
		this.msg = msg;
	}
	
  @Override
  public String getMessage() {
	return msg;
  }

}