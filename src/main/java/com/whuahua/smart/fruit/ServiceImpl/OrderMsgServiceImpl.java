package com.whuahua.smart.fruit.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.whuahua.smart.fruit.bo.OrderMsgBO;
import com.whuahua.smart.fruit.bo.QueryOrderMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.OrderMsgDAO;
import com.whuahua.smart.fruit.po.OrderMsgPO;
import com.whuahua.smart.fruit.service.OrderMsgService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class OrderMsgServiceImpl implements OrderMsgService {

	@Autowired
	private OrderMsgDAO orderMsgDAO;
	@Override
	public QueryOrderMsgBO selectByOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		QueryOrderMsgBO queryOrderMsgBO=new QueryOrderMsgBO();
		List<OrderMsgBO> orderMsgBOs=new ArrayList<>();
		try {
			List<OrderMsgPO> orderMsgPOs=orderMsgDAO.selectByOrderNum(orderNum);
			if(orderMsgPOs!=null&&orderMsgPOs.size()>0) {
				for(OrderMsgPO po:orderMsgPOs) {
				OrderMsgBO orderMsgBO=new OrderMsgBO();	
				orderMsgBO.setCommondityId(po.getCommondityId());
				orderMsgBO.setComName(po.getComName());
				orderMsgBO.setCreateTime(po.getCreateTime());
				orderMsgBO.setComPrice(po.getComPrice());
				orderMsgBO.setDetailId(po.getDetailId());
				orderMsgBO.setFruitNum(po.getFruitNum());
				orderMsgBO.setOrderNum(po.getOrderNum());
				orderMsgBO.setTotalPrice(po.getTotalPrice());
				orderMsgBOs.add(orderMsgBO);
				}
			}
			queryOrderMsgBO.setOrderMsgBOs(orderMsgBOs);
			queryOrderMsgBO.setRespCode(BaseCode.SUCCESS_CODE);
			queryOrderMsgBO.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			queryOrderMsgBO.setRespCode(BaseCode.FAIL_CODE);
			queryOrderMsgBO.setRespDesc(BaseCode.FAIL_DESC);
			return queryOrderMsgBO;
		}
		return queryOrderMsgBO;
	}

	@Override
	public RespBaseBO insert(OrderMsgBO orderMsgBO) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		try {
			OrderMsgPO orderMsgPO=new OrderMsgPO();
			orderMsgPO.setCommondityId(orderMsgBO.getCommondityId());
			orderMsgPO.setComName(orderMsgBO.getComName());
			orderMsgPO.setComPrice(orderMsgBO.getComPrice());
			orderMsgPO.setCreateTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
			orderMsgPO.setFruitNum(orderMsgBO.getFruitNum());
			orderMsgPO.setOrderNum(orderMsgBO.getOrderNum());
			orderMsgPO.setTotalPrice(orderMsgBO.getTotalPrice());
			int a=orderMsgDAO.insert(orderMsgPO);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				bo.setRespCode(BaseCode.FAIL_CODE);
				bo.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

	@Override
	public RespBaseBO delete(String orderNum) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		OrderMsgPO orderMsgPO=new OrderMsgPO();
		try {
			if(!StringUtils.isEmpty(orderNum)) {
				orderMsgPO.setOrderNum(orderNum);
			}
			int a=orderMsgDAO.insert(orderMsgPO);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				bo.setRespCode(BaseCode.FAIL_CODE);
				bo.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

}
