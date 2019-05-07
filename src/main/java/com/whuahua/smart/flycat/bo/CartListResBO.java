package com.whuahua.smart.flycat.bo;

import java.util.List;

public class CartListResBO extends ResBaseBO{

	private List<CartBO> result;
	private long totalPrice;

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartBO> getResult() {
		return result;
	}

	public void setResult(List<CartBO> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CartListResBO [result=" + result + ", totalPrice=" + totalPrice + "]";
	}
	
}
