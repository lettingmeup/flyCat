package com.whuahua.smart.flycat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.dao.LoginDao;
import com.whuahua.smart.flycat.po.UserPO;
import com.whuahua.smart.flycat.service.GetUserDetailService;



@Service
@Transactional
public class GetUserDetailServiceImpl implements GetUserDetailService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UserBO getUserDetail(UserBO userBO) {
		UserBO result = new UserBO();
		try {
		UserPO po = loginDao.getUserDetail(userBO.getUserPhone());
		if(po==null) {
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}else {
			result.setBackCode("000");
			result.setBackDesc("操作成功");
			result.setBuyCode(po.getBuyCode());
		
			result.setOpenid(po.getOpenid());
			result.setPassword("");
			result.setUserId(po.getUserId());
			result.setUserName(po.getUserName());
			result.setUserPhone(po.getUserPhone());
			result.setUserRole(po.getUserRole());
		
		}
		}catch(Exception e) {
			e.printStackTrace();
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}
	
	
	

}
