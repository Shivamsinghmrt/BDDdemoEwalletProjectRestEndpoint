package org.com.eWallet.controller;

import org.com.eWallet.dto.WalletUserdto;

import org.com.eWallet.error.AlreadyRegisteredUserException;
import org.com.eWallet.error.DuplicateAadharException;
import org.com.eWallet.error.RecordNotFoundException;
import org.com.eWallet.model.WalletAccount;

import org.com.eWallet.model.WalletUser;
import org.com.eWallet.service.WalletCreationService;
import org.com.eWallet.util.WalletUserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("wallet")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class WalletCreationController {

	@Autowired
	private WalletCreationService creationService;

	

	//Create new User Account
	@PostMapping(WalletUserConstants.ADD_USER_URL)
	
	public WalletAccount addUser( @RequestBody WalletUserdto walletUserdto ) throws AlreadyRegisteredUserException, RecordNotFoundException {
		
		creationService.addUser(walletUserdto);
        return creationService.addAccount(walletUserdto);
		
	}
		
	
	

	
	//Update UserAccount
	@PutMapping(WalletUserConstants.UPDATE_USER_URL)
	
	public WalletUser updateUser(@RequestBody WalletUserdto walletUserdto) throws RecordNotFoundException, DuplicateAadharException {
		WalletUser user = new WalletUser();

			user = creationService.updateUser(walletUserdto);
            return user;
	}
	
	
	
	//Returns wallet_user for given loginName and password
		@GetMapping(WalletUserConstants.VALIDATE_USER_URL)

		public WalletUser validLoginName(@PathVariable("loginName") String loginName,
				@PathVariable("password") String password) throws RecordNotFoundException {
			WalletUser user = new WalletUser();

			
				user = creationService.validLogin(loginName, password);


		
			return user;
		}

		


	}
