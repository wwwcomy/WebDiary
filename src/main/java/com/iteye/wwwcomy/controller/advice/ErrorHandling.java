package com.iteye.wwwcomy.controller.advice;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iteye.wwwcomy.model.dto.ValidationErrorMessage;
import com.iteye.wwwcomy.model.exception.EntityAlreadyExistsException;
import com.iteye.wwwcomy.model.exception.EntityNotFoundException;
import com.iteye.wwwcomy.model.exception.InvalidParameterException;

@RestControllerAdvice
public class ErrorHandling {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ValidationErrorMessage handle(Exception ex, HttpServletResponse response) {
		logger.error(ex.getMessage(), ex);
		ValidationErrorMessage message = new ValidationErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				ex.getMessage());
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return message;
	}

	/**
	 * Catches any {@link EntityAlreadyExistsException} and returns a response with
	 * bad request status.
	 *
	 */
	@ExceptionHandler({ EntityAlreadyExistsException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorMessage handle(EntityAlreadyExistsException ex, HttpServletResponse response) {
		logger.error(ex.getMessage(), ex);
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ValidationErrorMessage("exception", ex.getMessage());
	}

	/**
	 * Catches any {@link EntityNotFoundException} and returns a response with not
	 * found status.
	 *
	 */
	@ExceptionHandler({ EntityNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ValidationErrorMessage handle(EntityNotFoundException ex, HttpServletResponse response) {
		logger.error(ex.getMessage(), ex);
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return new ValidationErrorMessage("exception", ex.getMessage());
	}

	/**
	 * Catches any {@link InvalidParameterException} and returns a response with 400
	 * status.
	 *
	 */
	@ExceptionHandler({ InvalidParameterException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationErrorMessage handle(InvalidParameterException ex, HttpServletResponse response) {
		logger.error(ex.getMessage(), ex);
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ValidationErrorMessage("exception", ex.getMessage());
	}

}
