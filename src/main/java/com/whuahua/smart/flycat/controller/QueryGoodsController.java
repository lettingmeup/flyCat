package com.whuahua.smart.flycat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.whuahua.smart.flycat.bo.GoodsListResBO;
import com.whuahua.smart.flycat.service.QueryGoodsListService;

@RestController
@RequestMapping("/flycat/")
public class QueryGoodsController {
	
	@Autowired
	private QueryGoodsListService queryGoodsListService;
	
	@RequestMapping(value="getGoods" ,method=RequestMethod.POST)
	@ResponseBody
	public GoodsListResBO getGoods(){
		GoodsListResBO result = queryGoodsListService.goodsList();
		return result;
	}
	@RequestMapping(value="getGoodsById" ,method=RequestMethod.POST)
	@ResponseBody
	public GoodsListResBO getGoodsById(@RequestBody int goodsId){
		GoodsListResBO result = queryGoodsListService.queryById(goodsId);
		return result;
	}
	@RequestMapping(value="getGoodsByName" ,method=RequestMethod.POST)
	@ResponseBody
	public GoodsListResBO Name(@RequestBody String goodsName){
		GoodsListResBO result = queryGoodsListService.queryByName(goodsName);
		return result;
	}
	
}
