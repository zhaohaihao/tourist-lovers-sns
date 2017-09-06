package com.bigsea.sns.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigsea.sns.model.exception.BaseException;
import com.bigsea.sns.web.constant.CtrlConstant.ResultField;
import com.bigsea.sns.web.constant.CtrlConstant.ResultStatus;

/**
 * 基础控制类
 * 包含一些常用的方法
 * Created by zhh on 2017/08/16.
 */
public class BaseController {
	
	protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 统一处理成功的结果
	 * @param map 请求返回结果
	 */
	protected void handleSuc(Map<String, Object> map) {
		handleSuc(map, null);
	}
	
	/**
	 * 统一处理成功的结果
	 * @param map 请求返回结果
	 * @param msg 请求成功显示信息
	 */
	protected void handleSuc(Map<String, Object> map, String msg) {
		if (map == null) {
			map = new HashMap<>();
		}
		if (!map.containsKey(ResultField.DATA)) {
			map.put(ResultField.DATA, new HashMap<>());
		}
		map.put(ResultField.STATUS, ResultStatus.SUC);
		if (msg != null) {
			map.put(ResultField.MSG, msg);
		} else {
			map.put(ResultField.MSG, "操作成功!");
		}
	}
	
	/**
	 * 统一处理失败的结果
	 * @param map 请求返回结果
	 * @param msg 请求成功显示信息
	 */
	protected void handleErr(Map<String, Object> map, String msg) {
		handleErr(map, msg, null);
	}
	
	/**
	 * 统一处理失败的结果
	 * @param map 请求返回结果
	 * @param e 异常
	 */
	protected void handleErr(Map<String, Object> map, Exception e) {
		handleErr(map, null, e);
	}
	
	/**
	 * 统一处理失败的结果
	 * @param map 请求返回结果
	 * @param msg 请求成功显示信息
	 * @param e 异常
	 */
	protected void handleErr(Map<String, Object> map, String msg, Exception e) {
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(ResultField.DATA, new HashMap<String, Object>());
		map.put(ResultField.STATUS, ResultStatus.ERR);
		if (e != null) {
			if (e instanceof BaseException) {
				map.put(ResultField.MSG, e.getMessage());
			} else if (msg != null) {
				map.put(ResultField.MSG, msg);
				logger.error(e.getMessage(), e);
			} else {
				map.put(ResultField.MSG, "网络异常, 请稍后再试!");
				logger.error(e.getMessage(), e);
			}
		} else {
			if (msg != null) {
				map.put(ResultField.MSG, msg);
			} else {
				map.put(ResultField.MSG, "网络异常, 请稍后再试!");
			}
		}
	}
	
}
