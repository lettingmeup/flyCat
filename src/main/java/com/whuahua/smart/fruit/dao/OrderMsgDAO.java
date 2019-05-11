package com.whuahua.smart.fruit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.fruit.po.OrderMsgPO;
@Mapper
public interface OrderMsgDAO {
 public int insert(OrderMsgPO orderMsgPO);
 
 public int delete(String orderNum);
 
 public List<OrderMsgPO> selectByOrderNum(String orderNum);
}
