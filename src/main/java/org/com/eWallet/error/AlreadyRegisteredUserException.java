package org.com.eWallet.error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class AlreadyRegisteredUserException extends Exception {
	
	public AlreadyRegisteredUserException(String s) {
		super(s);
	}



}
