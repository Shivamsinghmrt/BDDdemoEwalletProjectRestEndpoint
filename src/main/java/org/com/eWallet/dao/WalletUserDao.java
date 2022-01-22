package org.com.eWallet.dao;

import java.util.Optional;


import org.com.eWallet.model.WalletUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletUserDao extends JpaRepository<WalletUser, Long>{

	
	
	
	
	//Returns all wallet_users for a given aadhaar_no
	@Query( value = "from WalletUser where aadhaarNo =:aadhaarno ")
	Optional<WalletUser> findByAadhaarNo(@Param("aadhaarno") long aadhaarNo);
	
	
	//Returns all wallet_users for given login_name and password
	
	@Query( value = "from WalletUser where loginName= :loginName and password= :password ")
	Optional<WalletUser> validLogin(@Param("loginName") String loginName, @Param("password") String password);
	
	

}
