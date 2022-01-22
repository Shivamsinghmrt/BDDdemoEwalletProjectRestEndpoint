package org.com.eWallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="WalletUser")
public class WalletUser {

	@Id
	@Column(name="phone_number")
	private long phoneNumber;
	
	

	@Column(name="user_name")
	private String userName;
	

	@Column(name="user_password")
	private String password;
	
	
	@Column(name="aadhaarNo",unique=true)
	private long aadhaarNo;
	
	
	@Column(name="login_name")
	private String loginName;
	
	
	@Override
		public String toString() {
			return "WalletUser [phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password
					+ ", aadhaarNo=" + aadhaarNo + ", loginName=" + loginName + "]";
		}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getAadhaarNo() {
		return aadhaarNo;
	}


	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}