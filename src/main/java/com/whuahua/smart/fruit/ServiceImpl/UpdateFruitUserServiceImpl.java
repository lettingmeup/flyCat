package com.whuahua.smart.fruit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitUserDAO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.UpdateFruitUserService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class UpdateFruitUserServiceImpl implements UpdateFruitUserService {
   @Autowired
   private FruitUserDAO fruitUserDAO;
	@Override
	public RespBaseBO update(FruitUserPO fruitUserPO) {
		// TODO Auto-generated method stub
		RespBaseBO resp=new RespBaseBO();
		try {
			int a=fruitUserDAO.update(fruitUserPO);
			if(a>0) {
				resp.setRespCode(BaseCode.SUCCESS_CODE);
				resp.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				resp.setRespCode(BaseCode.FAIL_CODE);
				resp.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			resp.setRespCode(BaseCode.FAIL_CODE);
			resp.setRespDesc(BaseCode.FAIL_DESC);
		}
		return resp;
	}

}
