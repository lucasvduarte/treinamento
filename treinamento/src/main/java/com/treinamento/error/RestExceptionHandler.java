package com.treinamento.error;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(Exception ex) {
		return new ErrorResponse(400, "Bad Request");
	}

	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex) {
		return new ErrorResponse(404, "Not Found");
	}
}