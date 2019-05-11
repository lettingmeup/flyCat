package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.FruitUserBO;

public interface SelectFruitUserService {
  public FruitUserBO select(FruitUserBO fruitUserBO);
  public FruitUserBO selectByTel(FruitUserBO fruitUserBO);
}
