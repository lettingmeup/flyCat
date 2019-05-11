package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.FruitYOrderBO;
import com.whuahua.smart.fruit.bo.QueryFruitYOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface FruitYOrderService {
 public RespBaseBO insert(FruitYOrderBO fruitYOrderBO);
 
 public RespBaseBO delect(Long id);
 
 public QueryFruitYOrderBO selectByUserId(Long id);
 
 public RespBaseBO updateNum(FruitYOrderBO fruitYOrderBO);
}
