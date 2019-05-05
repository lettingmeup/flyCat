package com.whuahua.smart.fruit.bo;

public class FruitUserBO extends RespBaseBO {
private String fruitUserId;

private String fruitTelNum;

private String password;

private String openId;

private String role;

public String getFruitUserId() {
	return fruitUserId;
}

public void setFruitUserId(String fruitUserId) {
	this.fruitUserId = fruitUserId;
}

public String getFruitTelNum() {
	return fruitTelNum;
}

public void setFruitTelNum(String fruitTelNum) {
	this.fruitTelNum = fruitTelNum;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getOpenId() {
	return openId;
}

public void setOpenId(String openId) {
	this.openId = openId;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}


}
