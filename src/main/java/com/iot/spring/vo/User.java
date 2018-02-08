package com.iot.spring.vo;

public class User {

	public int uino;
	public String uiname;
	public int uiage;
	public String uiid;
	public String uipwd;
	public String address;
	@Override
	public String toString() {
		return "User [uino=" + uino + ", uiname=" + uiname + ", uiage=" + uiage + ", uiid=" + uiid + ", uipwd=" + uipwd
				+ ", address=" + address + "]";
	}
	public int getUino() {
		return uino;
	}
	public void setUino(int uino) {
		this.uino = uino;
	}
	public String getUiname() {
		return uiname;
	}
	public void setUiname(String uiname) {
		this.uiname = uiname;
	}
	public int getUiage() {
		return uiage;
	}
	public void setUiage(int uiage) {
		this.uiage = uiage;
	}
	public String getUiid() {
		return uiid;
	}
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public String getUipwd() {
		return uipwd;
	}
	public void setUipwd(String uipwd) {
		this.uipwd = uipwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
