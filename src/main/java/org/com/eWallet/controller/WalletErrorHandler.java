package org.com.eWallet.controller;

import java.time.LocalDateTime;


import org.com.eWallet.dto.ErrorMessage;
import org.com.eWallet.error.AlreadyRegisteredUserException;
import org.com.eWallet.error.DuplicateAadharException;
import org.com.eWallet.error.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletErrorHandler {
	@ExceptionHandler(AlreadyRegisteredUserException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException1(AlreadyRegisteredUserException ex) {
		
		return new ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now().toString());
		
		
		
	}
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleException2(RecordNotFoundException ex) {
		
		return new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.toString(), LocalDateTime.now().toString());
		
		
		
	}
	
	
	@ExceptionHandler(DuplicateAadharException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorMessage handleException2(DuplicateAadharException ex) {
		
		return new ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now().toString());
		
		
		
	}
	
	

}
