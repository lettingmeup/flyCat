package com.whuahua.smart.flycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.flycat.bo.CartBO;
import com.whuahua.smart.flycat.bo.CartListResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.service.CartService;

@RestController
@RequestMapping("/flycat/")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="queryCart" ,method=RequestMethod.POST)
	@ResponseBody
	public CartListResBO queryCart(@RequestBody CartBO cartBO) {
		CartListResBO result = cartService.queryCart(cartBO);
		return result;
	}
	
	
	@RequestMapping(value="addCart" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO addCart(@RequestBody CartBO cartBO) {
		ResBaseBO result = cartService.addCart(cartBO);
		return result;
	}
	
	
	@RequestMapping(value="clearCart" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO clearCart(@RequestBody CartBO cartBO) {
		ResBaseBO result = cartService.clearCart(cartBO);
		return result;
	}
	
	@RequestMapping(value="removeCart" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO removeCart(@RequestBody CartBO cartBO) {
		ResBaseBO result = cartService.removeCart(cartBO);
		return result;
	}
	
	@RequestMapping(value="deleteList" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO deleteList(@RequestBody CartBO cartBO) {
		ResBaseBO result = cartService.deleteList(cartBO);
		return result;
	}
	
	
	

}
