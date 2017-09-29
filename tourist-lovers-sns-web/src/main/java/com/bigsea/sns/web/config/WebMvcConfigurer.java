package com.bigsea.sns.web.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bigsea.sns.model.constant.ProjectConstant;
import com.bigsea.sns.model.exception.ServiceException;
import com.bigsea.sns.model.result.Result;
import com.bigsea.sns.model.result.ResultCode;

/**
 * Spring MVC 配置
 * Created by zhh on 2017/09/18.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
	
	// 使用Fastjson解析JSON：继承 WebMvcConfigurerAdapter, 覆写configureMessageConverters方法
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 定义转换消息对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 添加fastjson配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue, // 保留空字段
				SerializerFeature.WriteNullStringAsEmpty, // String null -> ""
				SerializerFeature.WriteNullNumberAsZero); // Number null -> 0
		// 在转换器中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		fastConverter.setDefaultCharset(Charset.forName("UTF-8"));

		converters.add(fastConverter);
	}
	
	// 统一异常处理
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new HandlerExceptionResolver() {
			@Override
			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
					Exception e) {
				Result result = new Result();
				if (e instanceof ServiceException) {
					// 业务异常
					result.setCode(ResultCode.FAIL).setMsg(e.getMessage());
					logger.info(e.getMessage());
				} else if (e instanceof NoHandlerFoundException) {
					result.setCode(ResultCode.NOT_FOUND).setMsg(String.format(ProjectConstant.NOT_FOUND_RESULT, request.getRequestURI()));
				} else if (e instanceof ServletException) {
					result.setCode(ResultCode.FAIL).setMsg(e.getMessage());
				} else {
					result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMsg(String.format(ProjectConstant.INTERNAL_SERVER_ERROR_SIMPLE_RESULT, request.getRequestURI()));
					String msg;
					if (handler instanceof HandlerMethod) {
						HandlerMethod handlerMethod = (HandlerMethod) handler;
						msg = String.format(ProjectConstant.INTERNAL_SERVER_ERROR_DETAIL_RESULT, 
								request.getRequestURI(),
								handlerMethod.getBean().getClass().getName(),
								handlerMethod.getMethod().getName(),
								e.getMessage());
					} else {
						msg = e.getMessage();
					}
					logger.error(msg, e);
				}
				responseResult(response, result);
				return new ModelAndView();
			}
		});
	}

	// 解决跨域问题
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// registry.addMapping("/**");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }
	
	//================================ 内部方法 ================================
	// 返回结果处理
	private void responseResult(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setStatus(200);
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
