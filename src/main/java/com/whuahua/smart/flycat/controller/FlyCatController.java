package com.whuahua.smart.flycat.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flycat/")
public class FlyCatController {
	@RequestMapping(value="world" ,method=RequestMethod.GET)
	@ResponseBody
	public String helloWorld(){
		
		return "flycat";
	}
}
