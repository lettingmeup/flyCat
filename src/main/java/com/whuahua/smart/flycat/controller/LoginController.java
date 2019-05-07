package com.whuahua.smart.flycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.service.LoginService;

@RestController
@RequestMapping("/flycat/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO login(@RequestBody UserBO userBO) {
		ResBaseBO result = loginService.login(userBO);
		return result;
	}

}
