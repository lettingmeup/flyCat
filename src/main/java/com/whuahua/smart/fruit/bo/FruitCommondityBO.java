package com.whuahua.smart.fruit.bo;

public class FruitCommondityBO{
private Long commondityId;

private String comName;

private Long comPrice;

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



public Long getComPrice() {
	return comPrice;
}

public void setComPrice(Long comPrice) {
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
