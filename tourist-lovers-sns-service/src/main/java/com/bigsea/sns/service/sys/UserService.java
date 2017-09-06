package com.bigsea.sns.service.sys;

import com.bigsea.sns.model.sys.User;

/**
 * Created by zhh on 2017/09/06.
 */
public interface UserService {
	
	User findOne();
	
	User findUserById(Integer id);
}
