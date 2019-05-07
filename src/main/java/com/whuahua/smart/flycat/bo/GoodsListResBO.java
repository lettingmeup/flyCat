package com.whuahua.smart.flycat.bo;

import java.util.List;

public class GoodsListResBO extends ResBaseBO{
	private List<GoodsBO> result;

	public List<GoodsBO> getResult() {
		return result;
	}

	public void setResult(List<GoodsBO> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GoodsListResBO [result=" + result + "]";
	}

}
