package com.whuahua.flyCat;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Sofa
 *
 */
@ComponentScan(basePackages={"com.whuahua.flyCat"})
@SpringBootApplication
public class FlyCatApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyCatApplication.class, args);
	}

}
