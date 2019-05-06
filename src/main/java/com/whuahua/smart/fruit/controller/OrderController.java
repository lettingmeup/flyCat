package com.whuahua.smart.fruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whuahua.smart.fruit.bo.FruitOrderBO;
import com.whuahua.smart.fruit.bo.OrderMsgBO;
import com.whuahua.smart.fruit.bo.QueryFruitOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.service.FruitOrderService;
import com.whuahua.smart.fruit.service.OrderMsgService;
import com.whuahua.smart.fruit.util.BaseCode;

@RestController
@RequestMapping("/fruit/")
public class OrderController {
	
	@Autowired
	private FruitOrderService fruitOrderService;
	@Autowired
	private OrderMsgService orderMsgService;
	@RequestMapping(value="insertFruitOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertFruitUser(@RequestBody FruitOrderBO fruitOrderBO){
		RespBaseBO bo=fruitOrderService.insert(fruitOrderBO);
		return bo;
	}
	@RequestMapping(value="deleteFruitOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO delete(@RequestBody FruitOrderBO fruitOrderBO) {
		RespBaseBO respBaseBO=new RespBaseBO();
		RespBaseBO bo=fruitOrderService.delete(fruitOrderBO);
		RespBaseBO BO=orderMsgService.delete(fruitOrderBO.getOrderNum());
		if(BaseCode.SUCCESS_CODE.equals(bo.getRespCode())&&BaseCode.SUCCESS_CODE.equals(BO.getRespCode())) {
			respBaseBO.setRespCode(BaseCode.SUCCESS_CODE);
			respBaseBO.setRespDesc(BaseCode.SUCCESS_DESC);
		}else {
			respBaseBO.setRespCode(BaseCode.FAIL_CODE);
			respBaseBO.setRespDesc(BaseCode.FAIL_DESC);
		}
		return respBaseBO;
	}
	@RequestMapping(value="selectAllFruitOrder" ,method=RequestMethod.POST)
	@ResponseBody
	public QueryFruitOrderBO selectAll() {
		QueryFruitOrderBO bo=fruitOrderService.queryAll();
		return bo;
	}
	@RequestMapping(value="selectByIdToOrderMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public OrderMsgBO selectById(String orderNum) {
		OrderMsgBO orderMsgBO=orderMsgService.selectByOrderNum(orderNum);
		return orderMsgBO;
	}
	@RequestMapping(value="insertOrderMsg" ,method=RequestMethod.POST)
	@ResponseBody
	public RespBaseBO insertOrderMsg(@RequestBody OrderMsgBO orderMsgBO){
		RespBaseBO bo=orderMsgService.insert(orderMsgBO);
		return bo;
	}
}
