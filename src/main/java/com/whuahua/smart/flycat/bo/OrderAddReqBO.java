package com.whuahua.smart.flycat.bo;

import java.util.List;

public class OrderAddReqBO {
	
	private OrderBO orderBO;
	private List<OrderDetailBO> detailList;
	public OrderBO getOrderBO() {
		return orderBO;
	}
	public void setOrderBO(OrderBO orderBO) {
		this.orderBO = orderBO;
	}
	public List<OrderDetailBO> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<OrderDetailBO> detailList) {
		this.detailList = detailList;
	}
	@Override
	public String toString() {
		return "OrderAddReqBO [orderBO=" + orderBO + ", detailList=" + detailList + "]";
	}
	

}
