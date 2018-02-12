package com.iot.spring.vo;

public class UserInfoVO {
	
	private int uiNo;
	private String niName;
	private String uiId;
	private String uiPwd;
	private String uiEmail;
	private char admin;
	@Override
	public String toString() {
		return "UserInfoVO [uiNo=" + uiNo + ", niName=" + niName + ", uiId=" + uiId + ", uiPwd=" + uiPwd + ", uiEmail="
				+ uiEmail + ", admin=" + admin + "]";
	}
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getNiName() {
		return niName;
	}
	public void setNiName(String niName) {
		this.niName = niName;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiEmail() {
		return uiEmail;
	}
	public void setUiEmail(String uiEmail) {
		this.uiEmail = uiEmail;
	}
	public char getAdmin() {
		return admin;
	}
	public void setAdmin(char admin) {
		this.admin = admin;
	}
	
}
