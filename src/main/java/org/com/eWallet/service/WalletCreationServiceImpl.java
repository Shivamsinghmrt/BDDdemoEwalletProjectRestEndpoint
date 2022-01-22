package org.com.eWallet.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.com.eWallet.dao.WalletAccountDao;

import org.com.eWallet.dao.WalletUserDao;
import org.com.eWallet.dto.WalletUserdto;
import org.com.eWallet.error.AlreadyRegisteredUserException;
import org.com.eWallet.error.DuplicateAadharException;
import org.com.eWallet.error.RecordNotFoundException;
import org.com.eWallet.model.WalletAccount;
import org.com.eWallet.model.WalletUser;
import org.com.eWallet.util.WalletUserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("walletCreationServiceImpl")
@Transactional
public class WalletCreationServiceImpl implements WalletCreationService{

	@Autowired
	WalletUserDao userDao;
	
	@Autowired
	 WalletAccountDao accountDao;
	
	
	WalletUser user;
	WalletAccount account;
	
	
	//Create new WalletUser 
    public WalletUser addUser( WalletUserdto walletUserdto) throws AlreadyRegisteredUserException {
    	WalletUser walletuser=new WalletUser();
		
    	Optional <WalletUser> findById = userDao.findByAadhaarNo(walletUserdto.getAadhaarNo());
		if(!findById.isPresent())
		{   
		
			walletuser.setAadhaarNo(walletUserdto.getAadhaarNo());
			walletuser.setUserName(walletUserdto.getUserName());
			walletuser.setPassword(walletUserdto.getPassword());
			walletuser.setLoginName(walletUserdto.getLoginName());
			walletuser.setPhoneNumber(walletUserdto.getPhoneNumber());
			userDao.saveAndFlush(walletuser) ;
				
		return walletuser;
		}
		throw new AlreadyRegisteredUserException(WalletUserConstants.USER_ALREADY_AVAILABLE);
	}
    
    
 //validate the login credentials   
 public WalletUser validLogin(String loginName, String password) throws RecordNotFoundException {
 		
 		Optional<WalletUser> findById = userDao.validLogin(loginName, password);
 		if(findById.isPresent()) {
 			
 	 		
 	 		WalletUser user = findById.get();
 			return user;
 		}
 		
 		
 		throw new RecordNotFoundException(WalletUserConstants.INVALID_USER);
 		
 	}
 
    
   
   
   //Update WalletUser By Id
   public WalletUser updateUser( WalletUserdto walletUserdto) throws RecordNotFoundException, DuplicateAadharException {
		
		Optional <WalletUser> findById = userDao.findById(walletUserdto.getPhoneNumber());
		Optional <WalletUser> findById1 = userDao.findByAadhaarNo(walletUserdto.getAadhaarNo());
		
		if(findById.isPresent())
		{
			if(findById1.isPresent()&&walletUserdto.getPhoneNumber()!=findById1.get().getPhoneNumber()) {
				throw new DuplicateAadharException(WalletUserConstants.DUPLICATE_AADHAR);
			}	
			WalletUser walletuser=new WalletUser();
			walletuser.setAadhaarNo(walletUserdto.getAadhaarNo());
			walletuser.setUserName(walletUserdto.getUserName());
			walletuser.setPassword(walletUserdto.getPassword());
			walletuser.setLoginName(walletUserdto.getLoginName());
			walletuser.setPhoneNumber(walletUserdto.getPhoneNumber());
			WalletUser user = userDao.save(walletuser);
			return user;
			
			
		}
		throw new RecordNotFoundException(WalletUserConstants.USERID_NOT_FOUND);
	}
   
   
   

	
    
	

	//adding account after registering new user
	public WalletAccount addAccount(WalletUserdto walletUserdto) throws RecordNotFoundException {
		account=new WalletAccount();
		account.setAccountBalance(0.0f);
		account.setStatus("registered");
		account.setAccountId(walletUserdto.getPhoneNumber());
		Optional <WalletUser> findById = userDao.findByAadhaarNo(walletUserdto.getAadhaarNo());
		if(!findById.isPresent())
		{   
			
			throw new RecordNotFoundException(WalletUserConstants.USERID_NOT_FOUND);
		}
		WalletUser user= findById.get();
		account.setWalletUser(user);
		accountDao.saveAndFlush(account);
		return account;
		
	}
		
}
