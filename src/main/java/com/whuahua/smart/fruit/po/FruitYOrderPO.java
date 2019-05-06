package com.whuahua.smart.fruit.po;

public class FruitYOrderPO {
	private Long  yOrderId;
	private Long fruitUserId;
	private Long commondityId;
	private String comName;
	private Long comPrice;
	private String fruitNum;
	public Long getyOrderId() {
		return yOrderId;
	}
	public void setyOrderId(Long yOrderId) {
		this.yOrderId = yOrderId;
	}
	public Long getFruitUserId() {
		return fruitUserId;
	}
	public void setFruitUserId(Long fruitUserId) {
		this.fruitUserId = fruitUserId;
	}
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
	public String getFruitNum() {
		return fruitNum;
	}
	public void setFruitNum(String fruitNum) {
		this.fruitNum = fruitNum;
	}
	@Override
	public String toString() {
		return "FruitYOrderPO [yOrderId=" + yOrderId + ", fruitUserId=" + fruitUserId + ", commondityId=" + commondityId
				+ ", comName=" + comName + ", comPrice=" + comPrice + ", fruitNum=" + fruitNum + "]";
	}
	
	
	
	

}
