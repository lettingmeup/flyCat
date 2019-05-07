package com.whuahua.smart.flycat.po;

public class CartPO {
	private int goodsId;
	 private long goodsPrice;
	 private String goodsName;
	 private int userId;
	 private int countGoood;
	 private String goodsImg;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public long getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCountGoood() {
		return countGoood;
	}
	public void setCountGoood(int countGoood) {
		this.countGoood = countGoood;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	@Override
	public String toString() {
		return "CartPO [goodsId=" + goodsId + ", goodsPrice=" + goodsPrice + ", goodsName=" + goodsName + ", userId="
				+ userId + ", countGoood=" + countGoood + ", goodsImg=" + goodsImg + "]";
	}
	
}
