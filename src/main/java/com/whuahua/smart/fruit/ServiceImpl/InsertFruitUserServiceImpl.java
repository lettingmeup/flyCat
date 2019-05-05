package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.dao.FruitUserDAO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.InsertFruitUserService;
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class InsertFruitUserServiceImpl implements InsertFruitUserService {
@Autowired
private FruitUserDAO fruitUserDAO;
	@Override
	public int insert(FruitUserBO fruitUserbo) {
		// TODO Auto-generated method stub
		FruitUserPO fruitUserPO=new FruitUserPO();
		fruitUserPO.setFruitTelNum(fruitUserbo.getFruitTelNum());
		fruitUserPO.setFruitUserId(fruitUserbo.getFruitUserId());
		fruitUserPO.setOpenId(fruitUserbo.getOpenId());
		fruitUserPO.setPassword(fruitUserbo.getPassword());
		fruitUserPO.setRole(fruitUserbo.getRole());
		int a=fruitUserDAO.insert(fruitUserPO);
		return a;
	}

}
