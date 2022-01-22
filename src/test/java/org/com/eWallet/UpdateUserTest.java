package org.com.eWallet;

import org.com.eWallet.dto.WalletUserdto;
import org.com.eWallet.error.DuplicateAadharException;
import org.com.eWallet.error.RecordNotFoundException;
import org.com.eWallet.model.WalletUser;
import org.com.eWallet.service.WalletCreationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateUserTest {

	
	@Autowired
	WalletCreationService service;
	
	
	//positive case
	@Test
	public void updateUserOne() throws RecordNotFoundException, DuplicateAadharException {
		WalletUserdto dto= new WalletUserdto();
		dto.setAadhaarNo(1003282538l);
		dto.setPassword("hari123");
		dto.setPhoneNumber(9827000103l);
		dto.setLoginName("hari");
		dto.setUserName("hari singh");
		WalletUser actual=service.updateUser(dto);
		Assertions.assertNotNull(actual);
	}
//if record not found
	@Test
	public void updateUserTwo() throws RecordNotFoundException {
		WalletUserdto dto= new WalletUserdto();
		dto.setAadhaarNo(70883282538l);
		dto.setPassword("philips123");
		dto.setPhoneNumber(9910010001l);
		dto.setLoginName("philips");
		dto.setUserName("philips singh");
		Assertions.assertThrows(RecordNotFoundException.class, ()->service.updateUser(dto));
		
	
}
	//dublicate aadhar
	@Test
	public void updateUserThree() throws DuplicateAadharException {
		WalletUserdto dto= new WalletUserdto();
		dto.setAadhaarNo(666666666666l);
		dto.setPassword("philips123");
		dto.setPhoneNumber(7417378509l);
		dto.setLoginName("philips");
		dto.setUserName("philips singh");
		Assertions.assertThrows(DuplicateAadharException.class, ()->service.updateUser(dto));
		
	
}
	
	
	
}
