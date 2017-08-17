package com.bigsea.sns.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Demo
 * Created by zhh on 2017/08/16.
 */
public class Demo implements Serializable {
	
	private static final long serialVersionUID = -7442827471907314036L;
	
	// 返回数据忽略该属性
	@JSONField(serialize = false)
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


