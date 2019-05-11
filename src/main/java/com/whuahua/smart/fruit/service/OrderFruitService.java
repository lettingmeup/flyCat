package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.OrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface OrderFruitService {
	public RespBaseBO insert(OrderBO orderBO);
	 public RespBaseBO delete(String orderNum);

}
