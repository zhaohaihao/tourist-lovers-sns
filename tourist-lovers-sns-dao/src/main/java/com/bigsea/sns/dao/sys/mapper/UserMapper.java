package com.bigsea.sns.dao.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.bigsea.sns.model.sys.User;

/**
 * Created by zhh on 2017/09/06.
 */
public interface UserMapper {
	
	User findUserById(@Param("id") Integer id);
}
