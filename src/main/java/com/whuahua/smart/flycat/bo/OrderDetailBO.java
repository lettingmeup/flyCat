package com.whuahua.smart.flycat.bo;

import java.util.Date;

public class OrderDetailBO {

	private int detailId;
	private String orderNum;
	private String goodsName;
	private long goodsPrice;
	private int countGoood;
	private int goodsId;
	private Date createTime;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
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
	
	public int getCountGoood() {
		return countGoood;
	}
	public void setCountGoood(int countGoood) {
		this.countGoood = countGoood;
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
		return "OrderDetailBO [detailId=" + detailId + ", orderNum=" + orderNum + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", countGoood=" + countGoood + ", goodsId=" + goodsId + ", createTime="
				+ createTime + ", img=" + img + "]";
	}

}
