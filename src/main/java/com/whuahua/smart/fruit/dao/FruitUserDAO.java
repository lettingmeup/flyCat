package com.whuahua.smart.fruit.dao;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.FruitUserPO;
@Mapper
public interface FruitUserDAO {
  public int insert(FruitUserPO FruitUserPO);
  
  public int update(FruitUserPO FruitUserPO);
  
  public FruitUserPO select(FruitUserPO fruitUserPO);
  
}
