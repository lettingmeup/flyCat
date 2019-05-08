package com.whuahua.smart.flycat.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.flycat.bo.OrderAddReqBO;
import com.whuahua.smart.flycat.bo.OrderBO;
import com.whuahua.smart.flycat.bo.OrderDetailBO;
import com.whuahua.smart.flycat.bo.OrderDetailResBO;
import com.whuahua.smart.flycat.bo.OrderResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.dao.GoodsListDao;
import com.whuahua.smart.flycat.dao.OrderDao;
import com.whuahua.smart.flycat.po.GoodsPO;
import com.whuahua.smart.flycat.po.OrderDetailPO;
import com.whuahua.smart.flycat.po.OrderPO;
import com.whuahua.smart.flycat.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private GoodsListDao goodsListDao;
	
	@Override
	public OrderResBO queryOrder(int userId) {
		OrderResBO result = new OrderResBO();
		try {
			List<OrderPO> poList = orderDao.queryOrder(userId);
			List<OrderBO> boList = new ArrayList<>();
			if(poList.isEmpty()) {
				result.setBackCode("999");
				result.setBackDesc("操作失败");
				return result;
			}
			for(OrderPO po:poList) {
				OrderBO bo = new OrderBO();
				bo.setCountGooods(po.getCountGooods());
				bo.setCreateTime(po.getCreateTime());
				bo.setOrderId(po.getOrderId());
				bo.setOrderNum(po.getOrderNum());
				bo.setOrderPrice(po.getOrderPrice());
				bo.setOrderState(po.getOrderState());
				bo.setUserId(po.getUserId());
				boList.add(bo);
			}
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
	public OrderDetailResBO queryOrderDetail(String orderNum) {
		OrderDetailResBO result = new OrderDetailResBO();
		try {
			List<OrderDetailBO> boList = new ArrayList<>();
			List<OrderDetailPO> poList = orderDao.queryDetail(orderNum);
			if(poList.isEmpty()) {
				result.setBackCode("999");
				result.setBackDesc("操作失败");
				return result;
			}
			for(OrderDetailPO po:poList) {
				OrderDetailBO bo = new OrderDetailBO();
				List<GoodsPO> goods = goodsListDao.queryById(po.getGoodsId());
				bo.setImg(goods.get(0).getGoodsImg());
				bo.setCountGoood(po.getCountGoods());
				bo.setGoodsId(po.getGoodsId());
				bo.setGoodsName(po.getGoodsName());
				bo.setGoodsPrice(po.getGoodsPrice());
				boList.add(bo);
				
			}
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
	public ResBaseBO addOrder(OrderAddReqBO orderAddReqBO) {
		ResBaseBO result = new ResBaseBO();
		OrderBO orderBO = orderAddReqBO.getOrderBO();
		List<OrderDetailBO> detail = orderAddReqBO.getDetailList();
		try {
			OrderPO orderPo = new OrderPO();
			orderPo.setCountGooods(orderBO.getCountGooods());
			orderPo.setCreateTime(new Date());
			orderPo.setOrderNum(new SimpleDateFormat("HHmmss").format(new Date())+(int)((Math.random()*9+1)*100000));
			orderPo.setOrderPrice(orderBO.getOrderPrice());
			orderPo.setOrderState(orderBO.getOrderState());
			orderPo.setUserId(orderBO.getUserId());
			System.out.println(orderPo.toString());
			int a = orderDao.addOrder(orderPo);
			if(a>0) {
				for(OrderDetailBO bo:detail) {
					OrderDetailPO orderDetailPO = new OrderDetailPO();
					orderDetailPO.setCountGoods(bo.getCountGoood());
					orderDetailPO.setCreateTime(new Date());
					orderDetailPO.setGoodsId(bo.getGoodsId());
					orderDetailPO.setGoodsName(bo.getGoodsName());
					orderDetailPO.setGoodsPrice(bo.getGoodsPrice());
					orderDetailPO.setOrderNum(orderPo.getOrderNum());
					int b = orderDao.addOrderDetail(orderDetailPO);
					if(b<1) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						result.setBackCode("999");
						result.setBackDesc("操作失败");
						return result;
					}
					
				}
				result.setBackCode("000");
				result.setBackDesc("操作成功");
				
			}else {
				result.setBackCode("999");
				result.setBackDesc("操作失败");
				return result;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}
		// TODO Auto-generated method stub
		return result;
	}

	

}
