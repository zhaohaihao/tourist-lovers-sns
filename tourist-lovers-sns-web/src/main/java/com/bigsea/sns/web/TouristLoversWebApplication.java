package com.bigsea.sns.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bigsea.sns.model.constant.ProjectConstant;

/**
 * 启动项
 * Created by zhh on 2017/08/15.
 */
@SpringBootApplication(scanBasePackages = {ProjectConstant.BASE_PACKAGE})
public class TouristLoversWebApplication extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(TouristLoversWebApplication.class, args);
	}
	
}
