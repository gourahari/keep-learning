package com.goura.spring.data.error;

import org.springframework.http.HttpStatus;

public abstract class RestException extends Exception {

	private HttpStatus status;

	public RestException(String msg) {
		this(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public RestException(String msg, HttpStatus status) {
		super(msg);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
