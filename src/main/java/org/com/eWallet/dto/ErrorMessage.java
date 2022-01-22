package org.com.eWallet.dto;

public class ErrorMessage {
	private String message;
	private String code;
	private String timestamp;
	public ErrorMessage(String message, String code, String timestamp) {
		super();
		this.message = message;
		this.code = code;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	

}
