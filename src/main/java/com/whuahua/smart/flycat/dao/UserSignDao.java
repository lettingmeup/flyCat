package com.whuahua.smart.flycat.dao;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.flycat.po.UserPO;

@Mapper
public interface UserSignDao {
	int userSignIn(UserPO userPO);
}
