package com.bigsea.sns.web.config;

import static com.bigsea.sns.model.constant.ProjectConstant.*;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis 扫描接口
 * 使用的 tk.mybatis.spring.mapper.MapperScannerConfigurer,
 * 如果你不使用通用 @see MyMapper,
 * 可以改为 org.mybatis.spring.mapper.MapperScannerConfigurer.
 * Created by zhh on 2017/09/18.
 */
@Configuration
@AutoConfigureAfter(MybatisConfigurer.class) // 防止 MybatisMapperScannerConfigurer 执行过早
public class MybatisMapperScannerConfigurer {
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);
		
		// 配置通用Mapper
		Properties properties = new Properties();
		properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
		// insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		
		return mapperScannerConfigurer;
	}
	
}
