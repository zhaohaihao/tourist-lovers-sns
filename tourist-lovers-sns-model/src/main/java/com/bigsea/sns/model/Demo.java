package com.bigsea.sns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Demo
 * Created by zhh on 2017/08/16.
 */
@Entity // 表明实体Bean 持久化
@Table(name = "demo") // 对应映射数据库表名
public class Demo implements Serializable {
	
	private static final long serialVersionUID = -7442827471907314036L;
	
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略：自增长
	private Integer id;
	
	// 实体属性与表中字段对应关系
	@Column(name = "user_name")
	private String username;
	
	// 返回数据忽略该属性
	@JSONField(serialize = false)
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}


