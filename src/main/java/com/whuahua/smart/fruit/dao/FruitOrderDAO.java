package com.whuahua.smart.fruit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.FruitOrderPO;
@Mapper
public interface FruitOrderDAO {

	public List<FruitOrderPO> queryAll();
	
	public int insert(FruitOrderPO fruitOrderPO);
	
	public int delete(FruitOrderPO fruitOrderPO);
	
	public FruitOrderPO selectById(Long id);
}
