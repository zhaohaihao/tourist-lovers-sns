package com.bigsea.sns.model.sys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.JSON;

/**
 * 用户表
 * Created by zhh on 2017/09/06.
 */
@Entity
@Table(name = "tls_sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 2323522780772781259L;
	
	/**
	 * 用户ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;
	
	/**
	 * 昵称
	 */
	@Column(name = "nick_name")
	private String nickName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 生日
	 */
	private Date birth;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 所在地
	 */
	private String location;
	
	/**
	 * 个人简介
	 */
	private String summ;
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private Date createDate;
	
	/**
	 * 修改时间
	 */
	@Column(name = "update_date")
	private Date updateDate;
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSumm() {
		return summ;
	}

	public void setSumm(String summ) {
		this.summ = summ;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
