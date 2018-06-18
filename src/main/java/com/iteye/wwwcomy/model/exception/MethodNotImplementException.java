package com.iteye.wwwcomy.model.exception;

public class MethodNotImplementException extends RuntimeException {

	private static final long serialVersionUID = 7355933209374085533L;

	public MethodNotImplementException() {
	}

	public MethodNotImplementException(String s) {
		super(s);
	}

	public MethodNotImplementException(String s, Throwable e) {
		super(s, e);
	}
}
