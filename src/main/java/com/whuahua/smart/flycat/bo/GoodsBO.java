package com.whuahua.smart.flycat.bo;

public class GoodsBO extends ResBaseBO{
	
	 private int goodsId;
	 private String goodsName;
	 private long goodsPrice;
	 private String goodsImg;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
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
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	@Override
	public String toString() {
		return "GoodsBO [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsImg="
				+ goodsImg + "]";
	}
	 

}
