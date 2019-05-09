package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitUserDAO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.InsertFruitUserService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class InsertFruitUserServiceImpl implements InsertFruitUserService {
@Autowired
private FruitUserDAO fruitUserDAO;
	@Override
	public RespBaseBO insert(FruitUserBO fruitUserbo) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		try {
			FruitUserPO fruitUserPO=new FruitUserPO();
			fruitUserPO.setFruitTelNum(fruitUserbo.getFruitTelNum());
			fruitUserPO.setFruitUserId(fruitUserbo.getFruitUserId());
			fruitUserPO.setOpenId(fruitUserbo.getOpenId());
			fruitUserPO.setPassword(fruitUserbo.getPassword());
			fruitUserPO.setRole("02");
			fruitUserPO.setName(fruitUserbo.getName());
			int a=fruitUserDAO.insert(fruitUserPO);
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

}
