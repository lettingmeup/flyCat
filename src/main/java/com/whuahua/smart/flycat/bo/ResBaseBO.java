package com.whuahua.smart.flycat.bo;

public class ResBaseBO {
	private String backDesc;
	private String backCode;
	private String cookies;
	
	public String getCookies() {
		return cookies;
	}
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}
	public String getBackDesc() {
		return backDesc;
	}
	public void setBackDesc(String backDesc) {
		this.backDesc = backDesc;
	}
	public String getBackCode() {
		return backCode;
	}
	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}
	@Override
	public String toString() {
		return "ResBaseBO [backDesc=" + backDesc + ", backCode=" + backCode + ", cookies=" + cookies + "]";
	}
	

}
