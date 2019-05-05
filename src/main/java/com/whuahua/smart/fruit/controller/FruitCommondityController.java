package com.whuahua.smart.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.fruit.bo.QueryFruitCommondityBO;
import com.whuahua.smart.fruit.service.QueryFruitCommondityService;


@RestController
@RequestMapping("/fruit/")
public class FruitCommondityController {
	
	@Autowired
	private QueryFruitCommondityService queryFruitCommondityService;
	@RequestMapping(value="queryAll" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryFruitCommondityBO queryAll(){
		QueryFruitCommondityBO bo=queryFruitCommondityService.queryAll();
		return bo;
	}
	@RequestMapping(value="queryById" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryFruitCommondityBO queryById(@RequestBody Long id) {
		QueryFruitCommondityBO bo=queryFruitCommondityService.queryById(id);
		return bo;
	}
	@RequestMapping(value="queryByLikeName" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryFruitCommondityBO queryByLikeName(@RequestBody String name) {
		QueryFruitCommondityBO bo=queryFruitCommondityService.queryByLikeName(name);
		return bo;
	}
}
