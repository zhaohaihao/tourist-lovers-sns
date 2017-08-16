package com.bigsea.sns.model;

import com.alibaba.fastjson.JSON;

/**
 * Demo
 * Created by zhh on 2017/08/16.
 */
public class Demo {
	
	private Integer id;
	
	private String msg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}


