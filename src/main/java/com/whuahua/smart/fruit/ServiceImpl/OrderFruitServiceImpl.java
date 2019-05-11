package com.whuahua.smart.fruit.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.whuahua.smart.fruit.bo.FruitGoodsBO;
import com.whuahua.smart.fruit.bo.OrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitCommondityDAO;
import com.whuahua.smart.fruit.dao.FruitOrderDAO;
import com.whuahua.smart.fruit.dao.OrderMsgDAO;
import com.whuahua.smart.fruit.po.FruitCommondityPO;
import com.whuahua.smart.fruit.po.FruitOrderPO;
import com.whuahua.smart.fruit.po.OrderMsgPO;
import com.whuahua.smart.fruit.service.OrderFruitService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class OrderFruitServiceImpl implements OrderFruitService {

	@Autowired
	private FruitOrderDAO fruitOrderDAO;
	@Autowired
	private OrderMsgDAO orderMsgDAO;
	@Autowired
	private FruitCommondityDAO fruitCommondityDAO;
	@Override
	public RespBaseBO insert(OrderBO orderBO) {
		// TODO Auto-generated method stub
		RespBaseBO respBaseBO=new RespBaseBO();
		try {
			List<FruitGoodsBO> fruitGoodsBOs=orderBO.getFruitGoodsBOList();
			FruitOrderPO fruitOrderPO=new FruitOrderPO();
			fruitOrderPO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			fruitOrderPO.setTotalNum(orderBO.getTotalNum());
			fruitOrderPO.setFruitUserId(orderBO.getFruitUserId());
			String orderNum=new SimpleDateFormat("HHmmss").format(new Date())+(int)((Math.random()*9+1)*100000);
			fruitOrderPO.setOrderNum(orderNum);
			fruitOrderPO.setOrderState(orderBO.getOrderState());
			fruitOrderPO.setTotalPrice(orderBO.getTotalPrice());
			fruitOrderPO.setUpdateTime(orderBO.getUpdateTime());
			if(fruitGoodsBOs!=null&&fruitGoodsBOs.size()>0) {
				FruitCommondityPO fruitCommondityPO=fruitCommondityDAO.queryById(fruitGoodsBOs.get(0).getCommondityId());
				if(fruitCommondityPO!=null) {
					fruitOrderPO.setComPhDress(fruitCommondityPO.getComPhDress());
				}
			}
			int a=fruitOrderDAO.insert(fruitOrderPO);
			if(a>0) {
				respBaseBO.setRespCode(BaseCode.SUCCESS_CODE);
				respBaseBO.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				respBaseBO.setRespCode(BaseCode.FAIL_CODE);
				respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
				return respBaseBO;
			}
			if(fruitGoodsBOs!=null&&fruitGoodsBOs.size()>0) {
				for(FruitGoodsBO bo:fruitGoodsBOs) {
					OrderMsgPO orderMsgPO=new OrderMsgPO();
					orderMsgPO.setCommondityId(bo.getCommondityId());
					
					orderMsgPO.setComName(bo.getComName());
					orderMsgPO.setComPrice(bo.getComPrice());
					orderMsgPO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					orderMsgPO.setFruitNum(bo.getFruitNum());
					if(StringUtils.isEmpty(bo.getFruitNum())) {
						orderMsgPO.setFruitNum("1");
					}
					orderMsgPO.setOrderNum(orderNum);
					orderMsgPO.setTotalPrice(orderBO.getTotalPrice());
					int b=orderMsgDAO.insert(orderMsgPO);
					if(b>0) {
						respBaseBO.setRespCode(BaseCode.SUCCESS_CODE);
						respBaseBO.setRespDesc(BaseCode.SUCCESS_DESC);
					}else {
						respBaseBO.setRespCode(BaseCode.FAIL_CODE);
						respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
						return respBaseBO;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			respBaseBO.setRespCode(BaseCode.FAIL_CODE);
			respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
			return respBaseBO;
		}
		
		return respBaseBO;
	}
	 public RespBaseBO delete(String orderNum) {
		 RespBaseBO respBaseBO=new RespBaseBO();
		 try {
			 FruitOrderPO fruitOrderPO=new FruitOrderPO();
			 fruitOrderPO.setOrderNum(orderNum);
			 int a=fruitOrderDAO.delete(fruitOrderPO);
			 int b=orderMsgDAO.delete(orderNum);
			 if(a>0&&b>0) {
				 respBaseBO.setRespCode(BaseCode.SUCCESS_CODE);
				 respBaseBO.setRespDesc(BaseCode.SUCCESS_DESC);
			 }else {
				 respBaseBO.setRespCode(BaseCode.FAIL_CODE);
				 respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			respBaseBO.setRespCode(BaseCode.FAIL_CODE);
			respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
			return respBaseBO;
		}
		 return respBaseBO;
	 }

}
