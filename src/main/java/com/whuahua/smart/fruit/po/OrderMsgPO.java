package com.whuahua.smart.fruit.po;

public class OrderMsgPO {
	private Long detailId;
	
	private Long commondityId;
	
	private String orderNum;
	
	private String comName;
	
	private Long comPrice;
	
	private String fruitNum;
	
	private Long totalPrice;
	
	private String createTime;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getCommondityId() {
		return commondityId;
	}

	public void setCommondityId(Long commondityId) {
		this.commondityId = commondityId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	

}