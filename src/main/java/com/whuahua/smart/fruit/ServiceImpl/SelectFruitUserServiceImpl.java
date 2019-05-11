package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.dao.FruitUserDAO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.SelectFruitUserService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class SelectFruitUserServiceImpl implements SelectFruitUserService {

	@Autowired
	private FruitUserDAO fruitUserDAO;
	@Override
	public FruitUserBO select(FruitUserBO fruitUserBO) {
		// TODO Auto-generated method stub
		FruitUserBO bo=new FruitUserBO();
		try {
			FruitUserPO po=new FruitUserPO();
			po.setFruitTelNum(fruitUserBO.getFruitTelNum());
			FruitUserPO fruitUserPO=fruitUserDAO.select(po);
			bo.setFruitTelNum(fruitUserPO.getFruitTelNum());
			bo.setFruitUserId(fruitUserPO.getFruitUserId());
			bo.setOpenId(fruitUserPO.getOpenId());
			bo.setPassword(fruitUserPO.getPassword());
			bo.setRole(fruitUserPO.getRole());
			bo.setName(fruitUserPO.getName());
			if(bo.getPassword().equals(fruitUserBO.getPassword())) {
				bo.setCookies(fruitUserPO.getFruitTelNum());
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				FruitUserBO userbo=new FruitUserBO();
				userbo.setRespCode(BaseCode.FAIL_CODE);
				userbo.setRespDesc("密码不正确");
				return userbo;
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
	public FruitUserBO selectByTel(FruitUserBO fruitUserBO) {
		FruitUserBO bo=new FruitUserBO();
		try {
			FruitUserPO po=new FruitUserPO();
			po.setFruitTelNum(fruitUserBO.getFruitTelNum());
			FruitUserPO fruitUserPO=fruitUserDAO.select(po);
			bo.setFruitTelNum(fruitUserPO.getFruitTelNum());
			bo.setFruitUserId(fruitUserPO.getFruitUserId());
			bo.setOpenId(fruitUserPO.getOpenId());
			bo.setPassword(fruitUserPO.getPassword());
			bo.setRole(fruitUserPO.getRole());
			bo.setName(fruitUserPO.getName());
			bo.setRespCode(BaseCode.SUCCESS_CODE);
			bo.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

}
