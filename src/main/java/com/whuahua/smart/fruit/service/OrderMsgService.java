package com.whuahua.smart.fruit.service;

import com.whuahua.smart.fruit.bo.OrderMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface OrderMsgService {
	public OrderMsgBO selectByOrderNum(String orderNum);
	
	public RespBaseBO insert(OrderMsgBO orderMsgBO);
	
	public RespBaseBO delete(String orderNum);

}
