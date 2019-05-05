package com.whuahua.smart.flycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.service.UserSignInService;

@RestController
@RequestMapping("/flycat/")
public class UserSignInController {
	@Autowired
	private UserSignInService userSignInService;
	
	@RequestMapping(value="signIn" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO signIn(@RequestBody UserBO userBO) {
		ResBaseBO result = userSignInService.userSignIn(userBO);
		return result;
	}

}
