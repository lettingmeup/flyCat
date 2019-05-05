package com.whuahua.smart.flycat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.flycat.bo.GoodsBO;
import com.whuahua.smart.flycat.bo.GoodsListResBO;
import com.whuahua.smart.flycat.dao.GoodsListDao;
import com.whuahua.smart.flycat.po.GoodsPO;
import com.whuahua.smart.flycat.service.QueryGoodsListService;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class QueryGoodsListServiceImpl implements QueryGoodsListService {
 
	@Autowired
	private GoodsListDao goodsListDao;

	@Override
	public GoodsListResBO goodsList() {
		GoodsListResBO result = new GoodsListResBO();
		List<GoodsBO> boList = new ArrayList<>();
		try {
				List<GoodsPO> poList = goodsListDao.queryGoods();
				if(poList.isEmpty()) {
					result.setBackCode("999");
					result.setBackDesc("查询结果为空");
					return result;
				}
				for(GoodsPO po:poList) {
					GoodsBO bo = new GoodsBO();
					bo.setGoodsId(po.getGoodsId());
					bo.setGoodsImg(po.getGoodsImg());
					bo.setGoodsName(po.getGoodsName());
					bo.setGoodsPrice(po.getGoodsPrice());
					boList.add(bo);
				}
		}catch(Exception e) {
			result.setBackCode("999");
			result.setBackDesc("查询结果为空");
			return result;
		}
		result.setBackCode("000");
		result.setBackDesc("操作成功");
		result.setResult(boList);
		return result;
	}

	@Override
	public GoodsListResBO queryById(int goodsId) {
		GoodsListResBO result = new GoodsListResBO();
		List<GoodsBO> boList = new ArrayList<>();
		try {
				List<GoodsPO> poList = goodsListDao.queryById(goodsId);
				if(poList.isEmpty()) {
					result.setBackCode("999");
					result.setBackDesc("查询结果为空");
					return result;
				}
				for(GoodsPO po:poList) {
					GoodsBO bo = new GoodsBO();
					bo.setGoodsId(po.getGoodsId());
					bo.setGoodsImg(po.getGoodsImg());
					bo.setGoodsName(po.getGoodsName());
					bo.setGoodsPrice(po.getGoodsPrice());
					boList.add(bo);
				}
		}catch(Exception e) {
			e.printStackTrace();
			result.setBackCode("999");
			result.setBackDesc("查询结果为空");
			return result;
		}
		result.setBackCode("000");
		result.setBackDesc("操作成功");
		result.setResult(boList);
		return result;
	}

	@Override
	public GoodsListResBO queryByName(String goodsName) {
		GoodsListResBO result = new GoodsListResBO();
		List<GoodsBO> boList = new ArrayList<>();
		try {
				List<GoodsPO> poList = goodsListDao.queryByName(goodsName);
				if(poList.isEmpty()) {
					result.setBackCode("999");
					result.setBackDesc("查询结果为空");
					return result;
				}
				for(GoodsPO po:poList) {
					GoodsBO bo = new GoodsBO();
					bo.setGoodsId(po.getGoodsId());
					bo.setGoodsImg(po.getGoodsImg());
					bo.setGoodsName(po.getGoodsName());
					bo.setGoodsPrice(po.getGoodsPrice());
					boList.add(bo);
				}
		}catch(Exception e) {
			e.printStackTrace();
			result.setBackCode("999");
			result.setBackDesc("查询结果为空");
			return result;
		}
		result.setBackCode("000");
		result.setBackDesc("操作成功");
		result.setResult(boList);
		return result;
	}

	

	
	
	

}
