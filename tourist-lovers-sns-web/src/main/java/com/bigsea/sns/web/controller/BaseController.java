package com.bigsea.sns.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigsea.sns.model.constant.ProjectConstant;
import com.bigsea.sns.model.result.Result;
import com.bigsea.sns.model.result.ResultCode;

/**
 * 基础控制类
 * 包含一些常用的方法
 * Created by zhh on 2017/08/16.
 */
public class BaseController {
	
	protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 处理成功的响应结果
	 */
	protected Result handleSuc() {
		return new Result()
				.setCode(ResultCode.SUCCESS)
				.setMsg(ProjectConstant.SUCCESS_RESULT);
	}
	
	/**
	 * 处理成功的响应结果
	 * @param data 响应数据
	 */
	protected Result handleSuc(Object data) {
		return handleSuc().setData(data);
	}
	
	/**
	 * 处理失败的响应结果
	 * @param msg 失败响应信息
	 */
	protected Result handleErr(String msg) {
		return new Result()
				.setCode(ResultCode.FAIL)
				.setMsg(msg);
	}
	
}
