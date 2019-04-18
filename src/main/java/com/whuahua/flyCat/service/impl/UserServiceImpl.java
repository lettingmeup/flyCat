package com.whuahua.flyCat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whuahua.flyCat.bo.UserBO;
import com.whuahua.flyCat.dao.QueryUserDao;
import com.whuahua.flyCat.po.UserPO;
import com.whuahua.flyCat.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private QueryUserDao queryUserDao;
	
	@Override
	public UserBO queryUserDetail() {
		UserPO userPO = new UserPO();
		UserBO userBO = new UserBO();
		userPO = queryUserDao.getUserDetail();
		transPoToBo(userPO, userBO);
		return userBO;
	}

	private void transPoToBo(UserPO userPO, UserBO userBO) {
		userBO.setUserId(userPO.getUserId());
		userBO.setPassWord(userPO.getPassWord());
		userBO.setUserName(userPO.getUserName());
		userBO.setUserPhone(userPO.getUserPhone());
	}

}
