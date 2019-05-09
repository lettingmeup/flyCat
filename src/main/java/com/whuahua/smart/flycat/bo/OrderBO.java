package com.whuahua.smart.flycat.bo;

import java.util.Date;

public class OrderBO {
	private int orderId;
	private long orderPrice;
	private Date createTime;
	private int orderState;
	private String orderNum;
	private int userId;
	private Date updateTime;
	private int countGooods;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getCountGooods() {
		return countGooods;
	}
	public void setCountGooods(int countGooods) {
		this.countGooods = countGooods;
	}
	@Override
	public String toString() {
		return "OrderBO [orderId=" + orderId + ", orderPrice=" + orderPrice + ", createTime=" + createTime
				+ ", orderState=" + orderState + ", orderNum=" + orderNum + ", userId=" + userId + ", updateTime="
				+ updateTime + ", countGooods=" + countGooods + ", time=" + time + "]";
	}
	

}
