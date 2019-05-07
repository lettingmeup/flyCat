package com.whuahua.smart.flycat.po;

public class UserPO {
	 private int userId;
	  private String userPhone;
	  private String password;
	  private String openid;
	  private String userRole;
	  private String userName;
	  private String buyCode;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBuyCode() {
		return buyCode;
	}
	public void setBuyCode(String buyCode) {
		this.buyCode = buyCode;
	}
	@Override
	public String toString() {
		return "UserPO [userId=" + userId + ", userPhone=" + userPhone + ", password=" + password + ", openid=" + openid
				+ ", userRole=" + userRole + ", userName=" + userName + ", buyCode=" + buyCode + "]";
	}
}
