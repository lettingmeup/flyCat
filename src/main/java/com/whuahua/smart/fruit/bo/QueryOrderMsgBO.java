package com.whuahua.smart.fruit.bo;

import java.util.List;

public class QueryOrderMsgBO extends RespBaseBO{
	private List<OrderMsgBO> orderMsgBOs;

	public List<OrderMsgBO> getOrderMsgBOs() {
		return orderMsgBOs;
	}

	public void setOrderMsgBOs(List<OrderMsgBO> orderMsgBOs) {
		this.orderMsgBOs = orderMsgBOs;
	}
	
}
