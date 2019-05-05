package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.dao.FruitUserDAO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.SelectFruitUserService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
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
			bo.setRespCode(BaseCode.SUCCESS_CODE);
			bo.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
		}
		
		return bo;
	}

}
