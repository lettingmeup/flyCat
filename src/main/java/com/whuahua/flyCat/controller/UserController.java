package com.whuahua.flyCat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.flyCat.bo.UserBO;
import com.whuahua.flyCat.service.UserService;

@RestController
@RequestMapping("/get/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="user" ,method=RequestMethod.POST)
	@ResponseBody
	public UserBO getUserDetail(@RequestBody String hello) {
		UserBO userBO = new UserBO();
		System.out.println(hello);
		userBO = userService.queryUserDetail();
		return userBO;
	}

}
