package com.bigsea.sns.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动项
 * Created by zhh on 2017/08/15.
 */
@SpringBootApplication(scanBasePackages = {"com.bigsea.sns"})
public class TouristLoversWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TouristLoversWebApplication.class, args);
	}
	
}
