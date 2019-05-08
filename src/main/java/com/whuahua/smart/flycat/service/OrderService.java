package com.whuahua.smart.flycat.service;

import com.whuahua.smart.flycat.bo.OrderAddReqBO;
import com.whuahua.smart.flycat.bo.OrderDetailResBO;
import com.whuahua.smart.flycat.bo.OrderResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;

public interface OrderService {
	
	ResBaseBO addOrder(OrderAddReqBO orderAddReqBO);
	OrderResBO queryOrder(int userId);
	OrderDetailResBO queryOrderDetail(String orderNum);

}
