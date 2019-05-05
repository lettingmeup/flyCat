package com.whuahua.smart.flycat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whuahua.smart.flycat.bo.CartBO;
import com.whuahua.smart.flycat.bo.CartListResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.dao.CartDao;
import com.whuahua.smart.flycat.po.CartPO;
import com.whuahua.smart.flycat.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public CartListResBO queryCart(CartBO cartBO) {
		CartListResBO result = new CartListResBO();
		List<CartBO> boList = new ArrayList<>();
		long total = 0;
		try {
		List<CartPO> poList = cartDao.queryCart(cartBO);
		if(poList.size()==0) {
			result.setBackCode("999");
			result.setBackDesc("查询结果为空");
			return result;
		}
		for(CartPO po:poList) {
			CartBO bo = new CartBO();
			bo.setCountGoood(po.getCountGoood());
			bo.setGoodsId(po.getGoodsId());
			bo.setGoodsImg(po.getGoodsImg());
			bo.setGoodsName(po.getGoodsName());
			bo.setGoodsPrice(po.getGoodsPrice());
			bo.setUserId(po.getUserId());
			boList.add(bo);
			total = total+po.getGoodsPrice();
		}
		    result.setTotalPrice(total);
		    result.setResult(boList);
		    result.setBackCode("000");
		    result.setBackDesc("操作成功");
		   
		}catch(Exception e) {
			e.printStackTrace();
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

	@Override
	public ResBaseBO addCart(CartBO cartBO) {
		ResBaseBO result = new ResBaseBO();
		try {
			CartPO po = cartDao.hasCart(cartBO);
		if(po!=null) {
			CartBO update = new CartBO();
			update.setGoodsId(cartBO.getGoodsId());
			update.setUserId(cartBO.getUserId());
			update.setGoodsPrice(po.getGoodsPrice()+cartBO.getGoodsPrice());
			update.setCountGoood(po.getCountGoood()+cartBO.getCountGoood());
			int up = cartDao.updateCart(update);
			if(up<1) {
				System.out.println(up);
				  result.setBackCode("999");
				  result.setBackDesc("操作失败");
				  return result;
			}
			  result.setBackCode("000");
			  result.setBackDesc("操作成功");
			
		}else {
		  int a = cartDao.addCart(cartBO);
		  if(a==0) {
			  result.setBackCode("999");
			  result.setBackDesc("操作失败");
			  return result;
		  }
		  result.setBackCode("000");
		  result.setBackDesc("操作成功");
		}
		}catch(Exception e) {
			e.printStackTrace();
			  result.setBackCode("999");
			  result.setBackDesc("操作失败");
			  return result;
		}
		return result;
	}

	@Override
	public ResBaseBO clearCart(CartBO cartBO) {
		ResBaseBO result = new ResBaseBO();
		try {
			int a = cartDao.clearCart(cartBO);
			if(a<1) {
				  result.setBackCode("999");
				  result.setBackDesc("操作失败");
				  return result;
			}
			  result.setBackCode("000");
			  result.setBackDesc("操作成功");
		}catch(Exception e) {
			e.printStackTrace();
			  result.setBackCode("999");
			  result.setBackDesc("操作失败");
			  return result;
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResBaseBO removeCart(CartBO cartBO) {
		ResBaseBO result = new ResBaseBO();
		try {
			CartPO po = cartDao.hasCart(cartBO);
			if(po!=null) {
				System.out.println(po.getCountGoood());
				CartBO update = new CartBO();
				if(po.getCountGoood()==1) {
					int a = cartDao.removeCart(cartBO);
					 if(a<1) {
						  result.setBackCode("999");
						  result.setBackDesc("操作失败");
						  return result;
					 }
					  result.setBackCode("000");
					  result.setBackDesc("操作成功");
				}else {
					update.setGoodsId(cartBO.getGoodsId());
					update.setUserId(cartBO.getUserId());
					update.setCountGoood(po.getCountGoood()-cartBO.getCountGoood());
					update.setGoodsPrice(po.getGoodsPrice()-cartBO.getGoodsPrice());
					int up = cartDao.updateCart(update);
					if(up<1) {
						result.setBackCode("999");
						result.setBackDesc("操作失败");
						return result;
					}
					result.setBackCode("000");
					result.setBackDesc("操作成功");
    		   }
			}else {
			 int a = cartDao.removeCart(cartBO);
			 if(a<1) {
				  result.setBackCode("999");
				  result.setBackDesc("操作失败");
				  return result;
			 }
			  result.setBackCode("000");
			  result.setBackDesc("操作成功");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			  result.setBackCode("999");
			  result.setBackDesc("操作失败");
			  return result;
		}
		return result;
	}

	

}
