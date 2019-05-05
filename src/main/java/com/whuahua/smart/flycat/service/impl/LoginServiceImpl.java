package com.whuahua.smart.flycat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.dao.LoginDao;
import com.whuahua.smart.flycat.po.UserPO;
import com.whuahua.smart.flycat.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public ResBaseBO login(UserBO userBO) {
		ResBaseBO result = new ResBaseBO();
		UserPO po = new UserPO();
		po.setBuyCode(userBO.getBuyCode());
		po.setOpenid(userBO.getOpenid());
		po.setPassword(userBO.getPassword());
		po.setUserId(userBO.getUserId());
		po.setUserName(userBO.getUserName());
		po.setUserPhone(userBO.getUserPhone());
		po.setUserRole(userBO.getUserRole());
		try {
		int has = loginDao.hasUser(po);
		if(has>0) {
			String pass = loginDao.getPass(po);
			if(userBO.getPassword().equals(pass)) {
				result.setBackCode("000");
				result.setBackDesc("操作成功");
				result.setCookies(userBO.getUserPhone());
			}else {
				result.setBackCode("999");
				result.setBackDesc("密码错误");
				return result;
			}
		}else {
			result.setBackCode("999");
			result.setBackDesc("用户不存在");
			return result;
		}
		
		}catch(Exception e) {
			result.setBackCode("999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

}
