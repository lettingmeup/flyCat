package com.whuahua.smart.flycat.dao;

import org.apache.ibatis.annotations.Mapper;

import com.whuahua.smart.flycat.po.UserPO;

@Mapper
public interface LoginDao {
   int hasUser(UserPO userPO);
   String getPass(UserPO userPO);
   UserPO getUserDetail(String userPhone);
}
