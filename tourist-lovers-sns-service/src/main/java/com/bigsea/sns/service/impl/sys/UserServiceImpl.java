package com.bigsea.sns.service.impl.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bigsea.sns.dao.mapper.sys.UserMapper;
import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.AbstractService;
import com.bigsea.sns.service.sys.UserService;
/**
 * Created by zhh on 2017/09/06.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {
	
	@Resource
	private UserMapper userMapper;
}
