package org.com.eWallet.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="WalletAccount")
public class WalletAccount {

	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", status=" + status + ", accountBalance=" + accountBalance
				+ ", walletUser=" + walletUser + "]";
	}

	@Id
	
	@Column(name="account_id")
	private long accountId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	//@JsonIgnore
	private WalletUser walletUser;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}
	 

	 
}
