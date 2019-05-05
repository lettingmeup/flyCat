package com.whuahua.smart.fruit.bo;

import java.util.List;

import com.whuahua.smart.fruit.po.FruitCommondityPO;

public class QueryFruitCommondityBO extends RespBaseBO{
private List<FruitCommondityBO> fruitCommondityBOList;
private FruitCommondityPO fruitCommondityPO;

public List<FruitCommondityBO> getFruitCommondityBOList() {
	return fruitCommondityBOList;
}

public void setFruitCommondityBOList(List<FruitCommondityBO> fruitCommondityBOList) {
	this.fruitCommondityBOList = fruitCommondityBOList;
}

public FruitCommondityPO getFruitCommondityPO() {
	return fruitCommondityPO;
}

public void setFruitCommondityPO(FruitCommondityPO fruitCommondityPO) {
	this.fruitCommondityPO = fruitCommondityPO;
}

}
