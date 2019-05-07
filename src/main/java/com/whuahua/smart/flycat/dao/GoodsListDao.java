package com.whuahua.smart.flycat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.flycat.po.GoodsPO;



@Mapper
public interface GoodsListDao {

	List<GoodsPO> queryGoods();
	List<GoodsPO> queryById(int goodsId);
	List<GoodsPO> queryByName(String goodsName);
}
