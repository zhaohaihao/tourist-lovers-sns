package com.bigsea.sns.model.constant;
/**
 * 项目常量值
 * Created by zhh on 2017/09/18.
 */
public interface ProjectConstant {
	
	//================================ 项目包路径 ================================
	String BASE_PACKAGE = "com.bigsea.sns"; // 项目基础包
	
	String MODEL_PACKAGE = BASE_PACKAGE + ".model"; // 项目Model所在包
	String MAPPER_PACKAGE = BASE_PACKAGE + ".dao.mapper"; // 项目Mapper所在包
	String SERVICE_PACKAGE = BASE_PACKAGE + ".service"; // 项目Service所在包
	String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web.controller"; // 项目Controller所在包
	
	String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".dao.MyMapper"; // MyMapper插件基础接口的完全限定名
	
	//================================ 项目返回信息 ================================
	String SUCCESS_RESULT = "SUCCESS";
	String NOT_FOUND_RESULT = "接口 [%s] 不存在";
	String INTERNAL_SERVER_ERROR_SIMPLE_RESULT = "接口 [%s] 内部错误，请联系管理员!";
	String INTERNAL_SERVER_ERROR_DETAIL_RESULT = "接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s";
}
