package com.bigsea.sns.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageHelper;

import static com.bigsea.sns.model.constant.ProjectConstant.*;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * Mybatis & Mapper & PageHelper 配置
 * Created by zhh on 2017/09/18.
 */

@Configuration
public class MybatisConfigurer {
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTypeAliasesPackage(MODEL_PACKAGE);
		
		// 配置分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		// 分页尺寸为0时查询所有纪录不再执行分页
		properties.setProperty("pageSizeZero", "true");
		// 页码<=0 查询第一页，页码>=总页数查询最后一页
		properties.setProperty("reasonable", "true");
		// 支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);
        
        // 添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});
        
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
        	factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        	return factory.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        
	}
	
}
