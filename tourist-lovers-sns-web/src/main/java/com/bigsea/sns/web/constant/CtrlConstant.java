package com.bigsea.sns.web.constant;
/**
 * 常量域
 * Created by zhh on 2017/08/16.
 */
public interface CtrlConstant {
	
	/**
	 * 返回结果属性
	 */
	interface ResultField {
		String DATA = "data";
		String STATUS = "status";
		String MSG = "msg";
	}
	
	/**
	 * 返回结果状态
	 */
	interface ResultStatus {
		String SUC = "success";
		String ERR = "error";
		String FAIL = "fail";
	}
	
	/**
	 * 页面跳转
	 */
	interface JumpPage {
		String DEF = "index.html";
	}
}
