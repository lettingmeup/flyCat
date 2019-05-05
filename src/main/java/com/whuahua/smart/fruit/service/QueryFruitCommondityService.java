package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.QueryFruitCommondityBO;

public interface QueryFruitCommondityService {
  public QueryFruitCommondityBO queryAll();
  
  public QueryFruitCommondityBO queryById(Long id);
  
  public QueryFruitCommondityBO queryByLikeName(String name);
}
