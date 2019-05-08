package com.whuahua.smart.flycat.bo;

import java.util.List;

public class OrderDetailResBO extends ResBaseBO{
	private List<OrderDetailBO> result;

	public List<OrderDetailBO> getResult() {
		return result;
	}

	public void setResult(List<OrderDetailBO> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "OrderDetailResBO [result=" + result + "]";
	}

}
