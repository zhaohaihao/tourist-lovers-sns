package com.bigsea.sns.model.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * 角色表
 * Created by zhh on 2017/09/06.
 */
@Entity
@Table(name = "tls_sys_roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 4354846220044038581L;
	
	/**
	 * 角色ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 角色名
	 */
	private String name;
	
	/**
	 * 状态
	 * 1.启用
	 * 2.停用
	 * 默认1
	 */
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
