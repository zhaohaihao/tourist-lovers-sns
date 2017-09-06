package com.bigsea.sns.model.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * 用户角色表
 * Created by zhh on 2017/09/06.
 */
@Entity
@Table(name = "tls_sys_userrole")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 4426841664219457503L;
	
	/**
	 * 用户角色ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 角色ID
	 */
	@Column(name = "role_id")
	private Integer roleId;
	
	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
