package com.whuahua.smart.flycat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.flycat.bo.OrderAddReqBO;
import com.whuahua.smart.flycat.bo.OrderDetailResBO;
import com.whuahua.smart.flycat.bo.OrderResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;
import com.whuahua.smart.flycat.service.OrderService;

@RestController
@RequestMapping("/flycat/")
public class FlyOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="addOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public ResBaseBO addOrder(@RequestBody OrderAddReqBO orderAddReqBO) {
		ResBaseBO result = new ResBaseBO();
		System.out.println(orderAddReqBO);
		result = orderService.addOrder(orderAddReqBO);
		return result;
	}
	
	@RequestMapping(value="queryOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public OrderResBO queryOrder(@RequestBody int userId) {
		OrderResBO result = new OrderResBO();
		result = orderService.queryOrder(userId);
		return result;
	}

	@RequestMapping(value="queryOrderDetail" ,method=RequestMethod.POST)
	@ResponseBody
	public OrderDetailResBO queryOrderDetail(@RequestBody String orderNum) {
		OrderDetailResBO result = new OrderDetailResBO();
		result = orderService.queryOrderDetail(orderNum);
		return result;
	}


}
