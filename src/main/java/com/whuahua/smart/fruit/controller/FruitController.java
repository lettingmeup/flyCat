package com.whuahua.smart.fruit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit/")
public class FruitController {
	@RequestMapping(value="world" ,method=RequestMethod.GET)
	@ResponseBody
	public String helloWorld(){
		
		return "fruit";
	}
}
