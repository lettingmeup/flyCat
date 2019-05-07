package com.whuahua.smart.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.fruit.bo.FruitUserBO;
import com.whuahua.smart.fruit.bo.FruitUserMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.po.FruitUserPO;
import com.whuahua.smart.fruit.service.FruitUserMsgService;
import com.whuahua.smart.fruit.service.InsertFruitUserService;
import com.whuahua.smart.fruit.service.SelectFruitUserService;
import com.whuahua.smart.fruit.service.UpdateFruitUserService;

@RestController
@RequestMapping("/fruit/")
public class FruitUserMsgController {
	
	@Autowired
	private InsertFruitUserService insertFruitUserService;
	@Autowired
	private UpdateFruitUserService UpdateFruitUserService;
	@Autowired
	private FruitUserMsgService fruitUserMsgService;
	@Autowired
	private SelectFruitUserService selectFruitUserService;
	@RequestMapping(value="insert" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertFruitUser(@RequestBody FruitUserBO fruitUserBO){
		RespBaseBO a=insertFruitUserService.insert(fruitUserBO);
		return a;
	}
	@RequestMapping(value="updatePassword" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO updatePassword(@RequestBody FruitUserPO fruitUserPO) {
		RespBaseBO res=UpdateFruitUserService.update(fruitUserPO);
		return res;
	}
	@RequestMapping(value="insertUserMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertFruitUserMsg(@RequestBody FruitUserMsgBO fruitUserMsgBO) {
		RespBaseBO bo=fruitUserMsgService.insert(fruitUserMsgBO);
		return bo;
	}
	@RequestMapping(value="updateUserMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO updateFruitUserMsg(@RequestBody FruitUserMsgBO fruitUserMsgBO) {
		RespBaseBO bo=fruitUserMsgService.update(fruitUserMsgBO);
		return bo;
	}
	@RequestMapping(value="selectUser" ,method=RequestMethod.POST)
	@ResponseBody
	public FruitUserBO selectUser(@RequestBody FruitUserBO fruitUserBO) {
		FruitUserBO bo=selectFruitUserService.select(fruitUserBO);
		return bo;
	}
}
