package com.whuahua.smart.fruit.service;

import java.util.List;

import com.whuahua.smart.fruit.bo.OrderMsgBO;
import com.whuahua.smart.fruit.bo.QueryOrderMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;

public interface OrderMsgService {
	public QueryOrderMsgBO selectByOrderNum(String orderNum);
	
	public RespBaseBO insert(OrderMsgBO orderMsgBO);
	
	public RespBaseBO delete(String orderNum);

}
