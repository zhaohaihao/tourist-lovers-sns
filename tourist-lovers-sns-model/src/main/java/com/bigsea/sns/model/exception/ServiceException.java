package com.bigsea.sns.model.exception;
/**
 * 业务异常, 该异常只做 INFO 级别的日志记录.
 * @see WebMvcConfigurer
 * Created by zhh on 2017/09/18.
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
