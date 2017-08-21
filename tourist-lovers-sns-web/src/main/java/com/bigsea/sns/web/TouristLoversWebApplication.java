package com.bigsea.sns.web;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 启动项
 * Created by zhh on 2017/08/15.
 */
// 申明SpringBoot为程序进行必要配置, 等价使用 @Configuration, @EnableAutoConfiguration 和 @ComponentScan
@SpringBootApplication(scanBasePackages = {"com.bigsea.sns"})
@EntityScan(basePackages = {"com.bigsea.sns.model"})
@MapperScan("com.bigsea.sns.dao.demo.mapper")
@EnableJpaRepositories({"com.bigsea.sns.dao"}) // 用于 Jpa的代码配置
public class TouristLoversWebApplication extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(TouristLoversWebApplication.class, args);
	}
	
	// 使用fastjson解析JSON：启动类继承 WebMvcConfigurerAdapter, 覆写configureMessageConverters方法
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 定义转换消息对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 添加fastjson配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 在转换器中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		converters.add(fastConverter);
	}
	
}
