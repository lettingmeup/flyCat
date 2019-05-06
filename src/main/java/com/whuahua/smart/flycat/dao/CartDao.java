package com.whuahua.smart.flycat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.flycat.bo.CartBO;

import com.whuahua.smart.flycat.po.CartPO;

@Mapper
public interface CartDao {
	CartPO hasCart(CartBO cartBO);
	List<CartPO> queryCart(CartBO cartBO);
	int addCart(CartBO cartBO);
	int clearCart(CartBO cartBO);
	int removeCart(CartBO cartBO);
	int updateCart(CartBO cartBO);
}
