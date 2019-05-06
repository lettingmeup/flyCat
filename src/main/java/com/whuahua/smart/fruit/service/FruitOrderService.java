package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.FruitOrderBO;
import com.whuahua.smart.fruit.bo.QueryFruitOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface FruitOrderService {
 public QueryFruitOrderBO queryAll();
 
 public RespBaseBO insert(FruitOrderBO fruitOrderBO);
 
 public RespBaseBO delete(FruitOrderBO fruitOrderBO);
 
 public QueryFruitOrderBO selectById(Long id);
}
