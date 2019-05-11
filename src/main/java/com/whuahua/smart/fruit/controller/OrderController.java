package com.whuahua.smart.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.fruit.bo.FruitOrderBO;
import com.whuahua.smart.fruit.bo.OrderBO;
import com.whuahua.smart.fruit.bo.OrderMsgBO;
import com.whuahua.smart.fruit.bo.QueryFruitOrderBO;
import com.whuahua.smart.fruit.bo.QueryOrderMsgBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.service.FruitOrderService;
import com.whuahua.smart.fruit.service.OrderMsgService;
import com.whuahua.smart.fruit.service.OrderService;
import com.whuahua.smart.fruit.util.BaseCode;

@RestController
@RequestMapping("/fruit/")
public class OrderController {
	
	@Autowired
	private FruitOrderService fruitOrderService;
	@Autowired
	private OrderMsgService orderMsgService;
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="insertOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertOrder(@RequestBody OrderBO orderBO){
		RespBaseBO bo=orderService.insert(orderBO);
		return bo;
	}
	@RequestMapping(value="deleteOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO delete(@RequestBody FruitOrderBO fruitOrderBO) {
		RespBaseBO respBaseBO=new RespBaseBO();
		if(!StringUtils.isEmpty(fruitOrderBO.getOrderNum())) {
			respBaseBO=orderService.delete(fruitOrderBO.getOrderNum());
		}
		return respBaseBO;
	}
	@RequestMapping(value="selectByUserIdAndOrderState" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryFruitOrderBO selectByUserIdAndOrderState(@RequestBody FruitOrderBO fruitOrderBO) {
		QueryFruitOrderBO bo=fruitOrderService.selectByUserIdAndOrderState(fruitOrderBO);
		return bo;
	}
	@RequestMapping(value="selectByIdToOrderMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryOrderMsgBO selectById(@RequestBody String orderNum) {
		QueryOrderMsgBO queryOrderMsgBO=orderMsgService.selectByOrderNum(orderNum);
		return queryOrderMsgBO;
	}
	@RequestMapping(value="insertOrderMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertOrderMsg(@RequestBody OrderMsgBO orderMsgBO){
		RespBaseBO bo=orderMsgService.insert(orderMsgBO);
		return bo;
	}
	@RequestMapping(value="updateState" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO update(@RequestBody Long id){
		RespBaseBO bo=fruitOrderService.update(id);
		return bo;
	}
}
