package com.whuahua.flyCat.dao;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.flyCat.po.UserPO;

@Mapper
public interface QueryUserDao {
	
	UserPO getUserDetail();
}
