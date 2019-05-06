package com.whuahua.smart.fruit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.FruitYOrderPO;
@Mapper
public interface FruitYOrderDAO {
	public int insert(FruitYOrderPO fruitYOrderPO);

	public int delect(Long id);
	
	public List<FruitYOrderPO> selectAll();
	
	public int update(FruitYOrderPO fruitYOrderPO);
}
