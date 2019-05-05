package com.whuahua.smart.fruit.dao;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.FruitUserMsgPO;
@Mapper
public interface FruitUserMsgDAO {
 public int insert(FruitUserMsgPO fruitUserMsgPO);
 
 public int update(FruitUserMsgPO fruitUserMsgPO);
}
