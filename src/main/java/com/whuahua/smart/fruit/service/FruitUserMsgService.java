package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.FruitUserMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface FruitUserMsgService {
  public RespBaseBO insert(FruitUserMsgBO fruitUserMsgBO);
  
  public RespBaseBO update(FruitUserMsgBO fruitUserMsgBO);
  
}
