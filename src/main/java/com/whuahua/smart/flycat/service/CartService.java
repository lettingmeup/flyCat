package com.whuahua.smart.flycat.service;

import com.whuahua.smart.flycat.bo.CartBO;
import com.whuahua.smart.flycat.bo.CartListResBO;
import com.whuahua.smart.flycat.bo.ResBaseBO;

public interface CartService {
	CartListResBO queryCart(CartBO cartBO);
	ResBaseBO removeCart(CartBO cartBO);
	ResBaseBO clearCart(CartBO cartBO);
	ResBaseBO addCart(CartBO cartBO);
	ResBaseBO deleteList(CartBO cartBO);

}
