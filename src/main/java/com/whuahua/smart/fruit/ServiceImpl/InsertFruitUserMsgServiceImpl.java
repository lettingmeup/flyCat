package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitUserMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitUserMsgDAO;
import com.whuahua.smart.fruit.po.FruitUserMsgPO;
import com.whuahua.smart.fruit.service.FruitUserMsgService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class InsertFruitUserMsgServiceImpl implements FruitUserMsgService {

	@Autowired
	private FruitUserMsgDAO fruitUserMsgDAO;
	@Override
	public RespBaseBO insert(FruitUserMsgBO fruitUserMsgBO) {
		// TODO Auto-generated method stub
		RespBaseBO rsp=new RespBaseBO();
		FruitUserMsgPO po=new FruitUserMsgPO();
		int a=0;
		try {
			po.setFruitUserId(fruitUserMsgBO.getFruitUserId());
			po.setDress(fruitUserMsgBO.getDress());
			a=fruitUserMsgDAO.insert(po);
			if(a>0) {
				rsp.setRespCode(BaseCode.SUCCESS_CODE);
				rsp.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				rsp.setRespCode(BaseCode.FAIL_CODE);
				rsp.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			rsp.setRespCode(BaseCode.FAIL_CODE);
			rsp.setRespDesc(e.getMessage());
			return rsp;
		}
		
		
		return rsp;
	}

	@Override
	public RespBaseBO update(FruitUserMsgBO fruitUserMsgBO) {
		RespBaseBO rsp=new RespBaseBO();
		FruitUserMsgPO po=new FruitUserMsgPO();
		int a=0;
		try {
			po.setFruitUserId(fruitUserMsgBO.getFruitUserId());
			po.setDress(fruitUserMsgBO.getDress());
			a=fruitUserMsgDAO.update(po);
			if(a>0) {
				rsp.setRespCode(BaseCode.SUCCESS_CODE);
				rsp.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				rsp.setRespCode(BaseCode.FAIL_CODE);
				rsp.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			rsp.setRespCode(BaseCode.FAIL_CODE);
			rsp.setRespDesc(e.getMessage());
			return rsp;
		}
		
		
		return rsp;
	}

}
