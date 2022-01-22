package org.com.eWallet;

import org.com.eWallet.error.RecordNotFoundException;
import org.com.eWallet.model.WalletUser;
import org.com.eWallet.service.WalletCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ValidUserTest {

	
	@Autowired
	WalletCreationService service;
	
	//positive case
	@Test
	public void validUserOne() throws RecordNotFoundException {
		String loginName="vishal";
		String password="vishal123";
		
		WalletUser actual=service.validLogin(loginName,password);
		Assertions.assertNotNull(actual);
		
	}
	
//negative test
	@Test
	public void validUserTwo() throws RecordNotFoundException {
		String loginName="Deno";
		String password="098567000";
		
		Assertions.assertThrows(RecordNotFoundException.class, ()->service.validLogin(loginName, password));
		
	}
	
	
}
