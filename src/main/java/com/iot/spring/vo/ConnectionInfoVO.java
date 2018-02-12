package com.iot.spring.vo;

import java.util.Arrays;

public class ConnectionInfoVO {

	private int ciNo;
	private String niName;
	private String ciUrl;
	private int ciPort;
	private String ciDatabase;
	private String ciUser;
	private String ciPwd;
	private String ciEtc;
	private String uiId;
	@Override
	public String toString() {
		return "ConnectionInfoVO [ciNo=" + ciNo + ", niName=" + niName + ", ciUrl=" + ciUrl + ", ciPort=" + ciPort
				+ ", ciDatabase=" + ciDatabase + ", ciUser=" + ciUser + ", ciPwd=" + ciPwd + ", ciEtc=" + ciEtc
				+ ", uiId=" + uiId + "]";
	}
	public int getCiNo() {
		return ciNo;
	}
	public void setCiNo(int ciNo) {
		this.ciNo = ciNo;
	}
	public String getNiName() {
		return niName;
	}
	public void setNiName(String niName) {
		this.niName = niName;
	}
	public String getCiUrl() {
		return ciUrl;
	}
	public void setCiUrl(String ciUrl) {
		this.ciUrl = ciUrl;
	}
	public int getCiPort() {
		return ciPort;
	}
	public void setCiPort(int ciPort) {
		this.ciPort = ciPort;
	}
	public String getCiDatabase() {
		return ciDatabase;
	}
	public void setCiDatabase(String ciDatabase) {
		this.ciDatabase = ciDatabase;
	}
	public String getCiUser() {
		return ciUser;
	}
	public void setCiUser(String ciUser) {
		this.ciUser = ciUser;
	}
	public String getCiPwd() {
		return ciPwd;
	}
	public void setCiPwd(String ciPwd) {
		this.ciPwd = ciPwd;
	}
	public String getCiEtc() {
		return ciEtc;
	}
	public void setCiEtc(String ciEtc) {
		this.ciEtc = ciEtc;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}

}
