package com.whuahua.smart.flycat.po;

import java.util.Date;

public class OrderDetailPO {
	private int detailId;
	private String orderNum;
	private String goodsName;
	private long goodsPrice;
	private int countGoods;
	private int goodsId;
	private Date createTime;
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public long getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getCountGoods() {
		return countGoods;
	}
	public void setCountGoods(int countGoods) {
		this.countGoods = countGoods;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "OrderDetailPO [detailId=" + detailId + ", orderNum=" + orderNum + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", countGoods=" + countGoods + ", goodsId=" + goodsId + ", createTime="
				+ createTime + "]";
	}

}
