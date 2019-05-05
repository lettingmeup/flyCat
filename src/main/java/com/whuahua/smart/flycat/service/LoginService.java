package com.whuahua.smart.flycat.service;

import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.bo.UserBO;

public interface LoginService {
	ResBaseBO login(UserBO userBO);
}
