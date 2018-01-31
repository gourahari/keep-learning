package com.goura.spring.data.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestException {

	public NotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}

}
