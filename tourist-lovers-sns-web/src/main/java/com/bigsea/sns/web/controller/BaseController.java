package com.bigsea.sns.web.controller;
/**
 * 基础控制类
 * 包含一些常用的方法
 * Created by zhh on 2017/08/16.
 */

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigsea.sns.web.constant.CtrlConstant.ResultField;
import com.bigsea.sns.web.constant.CtrlConstant.ResultStatus;

public class BaseController {
	
	protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 统一处理成功的结果
	 */
	protected void handleSuc(Map<String, Object> map) {
		handleSuc(map, null);
	}
	
	/**
	 * 统一处理成功的结果(含信息)
	 */
	protected void handleSuc(Map<String, Object> map, String msg) {
		if (map == null) {
			map = new HashMap<>();
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
	 */
	protected void handleErr(Map<String, Object> map) {
		handleErr(map, null);
	}
	
	/**
	 * 统一处理失败的结果(含信息)
	 */
	protected void handleErr(Map<String, Object> map, String msg) {
		if (map == null) {
			map = new HashMap<>();
		}
		map.remove(ResultField.DATA);
		map.put(ResultField.STATUS, ResultStatus.ERR);
		if (msg != null) {
			map.put(ResultField.MSG, msg);
		} else {
			map.put(ResultField.MSG, "网络异常,请稍后再试!");
		}
	}
	
}
