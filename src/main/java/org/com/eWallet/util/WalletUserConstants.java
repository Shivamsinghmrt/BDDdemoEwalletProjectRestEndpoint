package org.com.eWallet.util;

public class WalletUserConstants {
	
	public static final String USER_ALREADY_AVAILABLE="User With This Aadhar Number Already Available";
	
	public static final String USERID_NOT_FOUND="User with this userId is not present";

	public static final String USERACCID_NOT_FOUND="User with this accountId is not present";
	
	public static final String INVALID_USER="Invalid Credentials";
	
	public static final String ADD_USER_URL="/adduser";
	
	public static final String UPDATE_USER_URL="/updateUser";
	
	public static final String DELETE_USER_URL="/deleteUser/{id}";
	
	public static final String VALIDATE_USER_URL="/validLogin/{loginName}/{password}";
	
	public static final String NO_USER="No User Found Inside The Database";

	public static final String DUPLICATE_AADHAR="This Aadhar Number Already Present";
}
