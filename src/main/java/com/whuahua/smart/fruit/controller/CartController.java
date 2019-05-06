package com.whuahua.smart.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.fruit.bo.FruitUserMsgBO;
import com.whuahua.smart.fruit.bo.FruitYOrderBO;
import com.whuahua.smart.fruit.bo.QueryFruitYOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.service.FruitYOrderService;

@RestController
@RequestMapping("/fruit/")
public class CartController {
	
	@Autowired
	private FruitYOrderService fruitYOrderService;
	@RequestMapping(value="insertFruitYOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertFruitYOrder(@RequestBody FruitYOrderBO fruitYOrderBO){
		RespBaseBO bo=fruitYOrderService.insert(fruitYOrderBO);
		return bo;
	}
	@RequestMapping(value="delectFruitYOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO delect(@RequestBody Long id) {
		RespBaseBO res=fruitYOrderService.delect(id);
		return res;
	}
	@RequestMapping(value="selectFruitYOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO selectAll() {
		QueryFruitYOrderBO bo=fruitYOrderService.selectAll();
		return bo;
	}
	@RequestMapping(value="updateNum" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO updateNum(@RequestBody FruitYOrderBO fruitYOrderBO) {
		RespBaseBO bo=fruitYOrderService.updateNum(fruitYOrderBO);
		return bo;
	}
}
