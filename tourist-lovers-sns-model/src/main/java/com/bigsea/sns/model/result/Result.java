package com.bigsea.sns.model.result;

import com.alibaba.fastjson.JSON;

/**
 * 统一 API 响应结果
 * Created by zhh on 2017/09/18.
 */
public class Result {
	
	private Integer code;
	private String msg;
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	
	public Result setCode(ResultCode resultCode) {
		this.code = resultCode.code;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public Object getData() {
		return data;
	}
	
	public Result setData(Object data) {
		this.data = data;
		return this;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
