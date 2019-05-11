package com.whuahua.smart.fruit.bo;

import java.util.List;

public class QueryFruitOrderBO extends RespBaseBO{

	private List<FruitOrderBO> fruitOrderBOList;
    
	private FruitOrderBO fruitOrderBO;
	
	private String comPhDress;
	

	public String getComPhDress() {
		return comPhDress;
	}

	public void setComPhDress(String comPhDress) {
		this.comPhDress = comPhDress;
	}

	public List<FruitOrderBO> getFruitOrderBOList() {
		return fruitOrderBOList;
	}

	public void setFruitOrderBOList(List<FruitOrderBO> fruitOrderBOList) {
		this.fruitOrderBOList = fruitOrderBOList;
	}

	public FruitOrderBO getFruitOrderBO() {
		return fruitOrderBO;
	}

	public void setFruitOrderBO(FruitOrderBO fruitOrderBO) {
		this.fruitOrderBO = fruitOrderBO;
	}
	
	
}
