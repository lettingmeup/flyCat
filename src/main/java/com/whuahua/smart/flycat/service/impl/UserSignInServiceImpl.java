package com.whuahua.smart.flycat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.dao.LoginDao;
import com.whuahua.smart.flycat.dao.UserSignDao;
import com.whuahua.smart.flycat.po.UserPO;
import com.whuahua.smart.flycat.service.UserSignInService;

@Service
public class UserSignInServiceImpl implements UserSignInService {

	@Autowired
	private UserSignDao userSignDao;
	@Autowired
	private LoginDao loginDao;
	@Override
	public ResBaseBO userSignIn(UserBO userBO) {
		ResBaseBO result = new ResBaseBO();
		UserPO userPO = new UserPO();
		userPO.setUserName(userBO.getUserName());
		userPO.setUserPhone(userBO.getUserPhone());
		userPO.setPassword(userBO.getPassword());
		userPO.setUserRole("3");
		try {
		int has = loginDao.hasUser(userPO);
		if(has>0) {
			result.setBackCode("999");
			result.setBackDesc("用户已存在");
			return result;
		}
		int count = userSignDao.userSignIn(userPO);
		if(count>0) {
			result.setBackCode("000");
			result.setBackDesc("操作成功");
		}
		}catch(Exception e) {
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

}
