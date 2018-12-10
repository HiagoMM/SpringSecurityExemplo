package com.unifacisa.lti.springSecurityExemplo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class AlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsException(String msg) {
	super(msg);
	}
}
