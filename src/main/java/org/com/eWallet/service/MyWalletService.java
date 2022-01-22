package org.com.eWallet.service;

import java.util.Optional;

import org.com.eWallet.dao.WalletAccountDao;
import org.com.eWallet.dao.WalletUserDao;
import org.com.eWallet.model.WalletAccount;
import org.com.eWallet.model.WalletUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyWalletService {

	@Autowired
	WalletUserDao userDao;
	
	@Autowired
	 WalletAccountDao accountDao;
	
	
	WalletUser user;
	WalletAccount account;
	
	//Show Balance By User Id
	public double showBalance(int uid) {
	
			return accountDao.getAccountBalance(uid);
	}
	//Get AccountId By UserId
	public Optional<Integer> getAccountId(int uid){
		
		return accountDao.getAccountId(uid);
	}

	//Get AccountName from UserId
	public Optional<String> getAccountName(int uid) {
		
		return accountDao.getAccountName(uid);
	}

	
}
