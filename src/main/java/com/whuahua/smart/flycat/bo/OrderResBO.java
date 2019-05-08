package com.whuahua.smart.flycat.bo;

import java.util.List;

public class OrderResBO extends ResBaseBO{
	private List<OrderBO> result;

	public List<OrderBO> getResult() {
		return result;
	}

	public void setResult(List<OrderBO> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "OrderResBO [result=" + result + "]";
	}
	

}
