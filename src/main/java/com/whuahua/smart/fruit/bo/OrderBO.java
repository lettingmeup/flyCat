package com.whuahua.smart.fruit.bo;

import java.util.List;

public class OrderBO{
	private Long fruitUserId;
	private String orderNum;
	private Long totalPrice;
	private String orderState;
	private String totalNum;
	private String createTime;
	private String updateTime;
	private List<FruitGoodsBO> fruitGoodsBOList;
	public Long getFruitUserId() {
		return fruitUserId;
	}
	public void setFruitUserId(Long fruitUserId) {
		this.fruitUserId = fruitUserId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public List<FruitGoodsBO> getFruitGoodsBOList() {
		return fruitGoodsBOList;
	}
	public void setFruitGoodsBOList(List<FruitGoodsBO> fruitGoodsBOList) {
		this.fruitGoodsBOList = fruitGoodsBOList;
	}
	
	
	

}
