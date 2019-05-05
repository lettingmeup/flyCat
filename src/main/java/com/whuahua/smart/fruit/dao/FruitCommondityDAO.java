package com.whuahua.smart.fruit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.FruitCommondityPO;
@Mapper
public interface FruitCommondityDAO {
 public List<FruitCommondityPO> queryAll();
 
 public FruitCommondityPO queryById(Long id);
 
 public FruitCommondityPO queryByLikeName(String name);
}
