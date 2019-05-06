package com.whuahua.smart.flycat.service;



import com.whuahua.smart.flycat.bo.GoodsListResBO;

public interface QueryGoodsListService {
	
	GoodsListResBO goodsList();
	GoodsListResBO queryById(int goodsId);
	GoodsListResBO queryByName(String goodsName);

}
