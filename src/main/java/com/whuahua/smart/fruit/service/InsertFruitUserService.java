package com.whuahua.smart.fruit.service;

import org.springframework.stereotype.Service;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
public interface InsertFruitUserService {
  public RespBaseBO insert(FruitUserBO fruitUserbo);
}
