package com.whuahua.smart.fruit.po;

public class FruitCommondityPO {
private Long commondityId;

private String comName;

private String comPrice;

private String comPhDress;

public Long getCommondityId() {
	return commondityId;
}

public void setCommondityId(Long commondityId) {
	this.commondityId = commondityId;
}

public String getComName() {
	return comName;
}

public void setComName(String comName) {
	this.comName = comName;
}

public String getComPrice() {
	return comPrice;
}

public void setComPrice(String comPrice) {
	this.comPrice = comPrice;
}

public String getComPhDress() {
	return comPhDress;
}

public void setComPhDress(String comPhDress) {
	this.comPhDress = comPhDress;
}

@Override
public String toString() {
	return "FruitCommondityPO [commondityId=" + commondityId + ", comName=" + comName + ", comPrice=" + comPrice
			+ ", comPhDress=" + comPhDress + "]";
}

}