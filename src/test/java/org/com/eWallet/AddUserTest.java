package org.com.eWallet;

import org.com.eWallet.dto.WalletUserdto;
import org.com.eWallet.error.AlreadyRegisteredUserException;
import org.com.eWallet.model.WalletUser;
import org.com.eWallet.service.WalletCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AddUserTest {
	
	@Autowired
	WalletCreationService service;
	
	
	//positive case
	@Test
	public void addUserOne() throws AlreadyRegisteredUserException {
		WalletUserdto dto= new WalletUserdto();
		dto.setAadhaarNo(706632825371l);
		dto.setPassword("vipul123");
		dto.setPhoneNumber(9926000103l);
		dto.setLoginName("vipul");
		dto.setUserName("vipul singh");
		WalletUser actual=service.addUser(dto);
		Assertions.assertNotNull(actual);
	}

	//negative case
	@Test
	public void addUserTwo() throws AlreadyRegisteredUserException {
		WalletUserdto dto= new WalletUserdto();
		dto.setAadhaarNo(70883282538l);
		dto.setPassword("shivam123");
		dto.setPhoneNumber(9927000103l);
		dto.setLoginName("vishal");
		dto.setUserName("vishal singh");
		Assertions.assertThrows(AlreadyRegisteredUserException.class, ()->service.addUser(dto));
		
		
		
        		

}
}