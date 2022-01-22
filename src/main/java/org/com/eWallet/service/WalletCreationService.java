package org.com.eWallet.service;

import org.com.eWallet.dto.WalletUserdto;
import org.com.eWallet.error.AlreadyRegisteredUserException;
import org.com.eWallet.error.DuplicateAadharException;
import org.com.eWallet.error.RecordNotFoundException;
import org.com.eWallet.model.WalletAccount;
import org.com.eWallet.model.WalletUser;
import org.springframework.stereotype.Component;

@Component
public interface WalletCreationService {

	public WalletUser addUser( WalletUserdto walletUserdto) throws AlreadyRegisteredUserException;
	public WalletAccount addAccount(WalletUserdto walletUserdto) throws RecordNotFoundException ;
	public WalletUser updateUser( WalletUserdto walletUserdto) throws RecordNotFoundException,DuplicateAadharException;
	public WalletUser validLogin(String loginName, String password)throws RecordNotFoundException;
	
	
}
