package com.whuahua.flyCat.po;

public class UserPO {
	   private Integer userId;
	   private String userName;
	   private String userPhone;
	   private String passWord;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "UserPO [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", passWord="
				+ passWord + "]";
	}
	   
	

}
