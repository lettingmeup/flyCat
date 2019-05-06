package com.whuahua.smart.flycat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.flycat.bo.CartBO;
import com.whuahua.smart.flycat.bo.CartListResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.dao.CartDao;
import com.whuahua.smart.flycat.po.CartPO;
import com.whuahua.smart.flycat.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public CartListResBO queryCart(CartBO cartBO) {
		CartListResBO result = new CartListResBO();
		List<CartBO> boList = new ArrayList<>();
		try {
		List<CartPO> poList = cartDao.queryCart(cartBO);
		if(poList.size()==0) {
			result.setBackCode("999");
			result.setBackDesc("查询结果为空");
			return result;
		}
		long count = 0;
		for(CartPO po:poList) {
			CartBO bo = new CartBO();
			bo.setCountGoood(po.getCountGoood());
			bo.setGoodsId(po.getGoodsId());
			bo.setGoodsImg(po.getGoodsImg());
			bo.setGoodsName(po.getGoodsName());
			bo.setGoodsPrice(po.getGoodsPrice());
			bo.setUserId(po.getUserId());
			count = count+(po.getGoodsPrice()*bo.getCountGoood());
			boList.add(bo);
		}
		    result.setTotalPrice(count);
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
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			  result.setBackCode("999");
			  result.setBackDesc("操作失败");
			  return result;
		}
		return result;
	}

	

}
