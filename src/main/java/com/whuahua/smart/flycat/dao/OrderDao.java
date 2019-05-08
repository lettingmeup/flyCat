package com.whuahua.smart.flycat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.flycat.po.OrderDetailPO;
import com.whuahua.smart.flycat.po.OrderPO;

@Mapper
public interface OrderDao {
	int addOrder(OrderPO orderPO);
	int addOrderDetail(OrderDetailPO orderDetailPO);
	List<OrderPO> queryOrder(int userId);
	List<OrderDetailPO> queryDetail(String orderNum);
}
