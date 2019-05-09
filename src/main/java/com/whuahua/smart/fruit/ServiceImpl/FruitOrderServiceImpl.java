package com.whuahua.smart.fruit.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitOrderBO;
import com.whuahua.smart.fruit.bo.QueryFruitOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitOrderDAO;
import com.whuahua.smart.fruit.po.FruitOrderPO;
import com.whuahua.smart.fruit.service.FruitOrderService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class FruitOrderServiceImpl implements FruitOrderService {

	@Autowired
	private FruitOrderDAO fruitOrderDAO;
	@Override
	public QueryFruitOrderBO queryAll() {
		// TODO Auto-generated method stub
		QueryFruitOrderBO queryFruitOrderBO=new QueryFruitOrderBO();
		List<FruitOrderBO> bolist=new ArrayList<>();
		try {
			List<FruitOrderPO> polist=fruitOrderDAO.queryAll();
			if(polist!=null&&polist.size()>0) {
				for(FruitOrderPO po:polist) {
					FruitOrderBO bo=new FruitOrderBO();
					bo.setCreateTime(po.getCreateTime());
					bo.setTotalNum(po.getTotalNum());
					bo.setFruitUserId(po.getFruitUserId());
					bo.setOrderNum(po.getOrderNum());
					bo.setOrderState(po.getOrderState());
					bo.setTotalPrice(po.getTotalPrice());
					bo.setUpdateTime(po.getUpdateTime());
					bolist.add(bo);
				}
				queryFruitOrderBO.setFruitOrderBOList(bolist);
				queryFruitOrderBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitOrderBO.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				queryFruitOrderBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitOrderBO.setRespDesc("查询为空");
				return queryFruitOrderBO;
			}
		} catch (Exception e) {
			// TODO: handle exception
			queryFruitOrderBO.setRespCode(BaseCode.FAIL_CODE);
			queryFruitOrderBO.setRespDesc(BaseCode.FAIL_DESC);
		}
		return queryFruitOrderBO;
	}

	@Override
	public RespBaseBO insert(FruitOrderBO fruitOrderBO) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		FruitOrderPO po=new FruitOrderPO();
		try {
			po.setCreateTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
			po.setTotalNum(fruitOrderBO.getTotalNum());
			po.setFruitUserId(fruitOrderBO.getFruitUserId());
			po.setOrderNum(new SimpleDateFormat("HHmmss").format(new Date())+(int)((Math.random()*9+1)*100000));
			po.setOrderState(fruitOrderBO.getOrderState());
			po.setTotalPrice(fruitOrderBO.getTotalPrice());
			po.setUpdateTime(fruitOrderBO.getUpdateTime());
			int a=fruitOrderDAO.insert(po);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
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
	public RespBaseBO delete(FruitOrderBO fruitOrderBO) {
		RespBaseBO bo=new RespBaseBO();
		FruitOrderPO po=new FruitOrderPO();
		try {
			po.setOrderNum(fruitOrderBO.getOrderNum());
			int a=fruitOrderDAO.delete(po);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
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
	public QueryFruitOrderBO selectById(Long id) {
		QueryFruitOrderBO bo=new QueryFruitOrderBO();
		FruitOrderBO fruitOrderBO=new FruitOrderBO();
		try {
				FruitOrderPO po=fruitOrderDAO.selectById(id);
				if(po!=null) {
					fruitOrderBO.setCreateTime(po.getCreateTime());
					fruitOrderBO.setTotalNum(po.getTotalNum());
					fruitOrderBO.setFruitUserId(po.getFruitUserId());
					fruitOrderBO.setOrderId(po.getOrderId());
					fruitOrderBO.setOrderNum(po.getOrderNum());
					fruitOrderBO.setOrderState(po.getOrderState());
					fruitOrderBO.setTotalPrice(po.getTotalPrice());
					fruitOrderBO.setUpdateTime(po.getUpdateTime());
					}
				bo.setFruitOrderBO(fruitOrderBO);
				bo.setRespCode(BaseCode.SUCCESS_CODE);
                bo.setRespDesc(BaseCode.SUCCESS_DESC);			
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
            bo.setRespDesc(BaseCode.FAIL_DESC);	
            return bo;
		}
		return bo;
	}
	 public QueryFruitOrderBO selectByUserIdAndOrderState(FruitOrderBO fruitOrderBO){
		 QueryFruitOrderBO queryFruitOrderBO=new QueryFruitOrderBO();
		 List<FruitOrderBO> fruitOrderBOs=new ArrayList<>();
		 try {
			 FruitOrderPO fruitOrderPO=new FruitOrderPO();
			 fruitOrderPO.setFruitUserId(fruitOrderBO.getFruitUserId());
			 fruitOrderPO.setOrderState(fruitOrderBO.getOrderState());
			 List<FruitOrderPO> fruitOrderPOs=fruitOrderDAO.selectByUserIdAndOrderState(fruitOrderPO);
			 if(fruitOrderPOs!=null&&fruitOrderPOs.size()>0) {
				 for(FruitOrderPO po:fruitOrderPOs) {
					 FruitOrderBO bo=new FruitOrderBO();
					 bo.setCreateTime(po.getCreateTime());
					 bo.setFruitUserId(po.getFruitUserId());
					 bo.setOrderId(po.getOrderId());
					 bo.setOrderNum(po.getOrderNum());
					 bo.setOrderState(po.getOrderState());
					 bo.setTotalNum(po.getTotalNum());
					 bo.setTotalPrice(po.getTotalPrice());
					 bo.setUpdateTime(po.getUpdateTime());
					 fruitOrderBOs.add(bo);
				 }
				 
			 }
			 queryFruitOrderBO.setFruitOrderBOList(fruitOrderBOs);
			 queryFruitOrderBO.setRespCode(BaseCode.SUCCESS_CODE);
			 queryFruitOrderBO.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			queryFruitOrderBO.setRespCode(BaseCode.FAIL_CODE);
			queryFruitOrderBO.setRespDesc(BaseCode.FAIL_DESC);
			return queryFruitOrderBO;
		}
		 return queryFruitOrderBO;
		 
	 }
public static void main(String[] args) {
	System.out.println(new SimpleDateFormat("HHmmss").format(new Date())+(int)((Math.random()*9+1)*100000));
}
}
