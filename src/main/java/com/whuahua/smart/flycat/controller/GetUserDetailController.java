package com.whuahua.smart.flycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.flycat.bo.UserBO;
import com.whuahua.smart.flycat.service.GetUserDetailService;

@RestController
@RequestMapping("/flycat/")
public class GetUserDetailController {
	
	@Autowired
	private GetUserDetailService getUserDetailService;
	
	@RequestMapping(value="userdetail" ,method=RequestMethod.POST)
	@ResponseBody
    public UserBO getUserDetail(@RequestBody UserBO userBO) {
		UserBO result = getUserDetailService.getUserDetail(userBO);
	   return result;
	}
}
