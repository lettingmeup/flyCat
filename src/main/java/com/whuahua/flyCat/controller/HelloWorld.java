package com.whuahua.flyCat.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/")
public class HelloWorld {
	@RequestMapping(value="world" ,method=RequestMethod.POST)
	@ResponseBody
	public String helloWorld(@RequestBody String hello){
		
		return hello+"World";
	}
}
