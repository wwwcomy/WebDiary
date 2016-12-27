package com.iteye.wwwcomy.model.exception;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4509231435194934224L;

	public NotFoundException(String message) {
		super(message);
	}

}
