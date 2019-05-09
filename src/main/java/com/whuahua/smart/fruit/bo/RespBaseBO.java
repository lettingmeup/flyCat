package com.whuahua.smart.fruit.bo;

public class RespBaseBO {
private String respCode;
private String respDesc;
private String cookies;

public String getCookies() {
	return cookies;
}
public void setCookies(String cookies) {
	this.cookies = cookies;
}
public String getRespCode() {
	return respCode;
}
public void setRespCode(String respCode) {
	this.respCode = respCode;
}
public String getRespDesc() {
	return respDesc;
}
public void setRespDesc(String respDesc) {
	this.respDesc = respDesc;
}
@Override
public String toString() {
	return "RespBaseBO [respCode=" + respCode + ", respDesc=" + respDesc + "]";
}

}
