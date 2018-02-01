package com.goura.spring.data.error;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

	private static final Logger logger = LogManager.getLogger(ErrorController.class);

	@ExceptionHandler(RestException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundException(RestException e) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("status", e.getStatus().toString());
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, e.getStatus());
	}

	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<Map<String, String>>  handleServletRequestBindingException(ServletRequestBindingException e) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("status", HttpStatus.BAD_REQUEST.toString());
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception e) {
		logger.error(e);
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorMap.put("message", e.getMessage());
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
