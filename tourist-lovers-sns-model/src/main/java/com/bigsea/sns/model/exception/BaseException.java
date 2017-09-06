package com.bigsea.sns.model.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	
	public BaseException() {
		super();
	}
	
	public BaseException(String msg) {
		super(msg);
	}
}
