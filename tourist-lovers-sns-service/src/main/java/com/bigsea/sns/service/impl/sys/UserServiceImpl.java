package com.bigsea.sns.service.impl.sys;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigsea.sns.dao.sys.mapper.UserMapper;
import com.bigsea.sns.dao.sys.repository.UserRepository;
import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;
/**
 * Created by zhh on 2017/09/06.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User findOne() {
		User user = userRepository.findOne(1);
		if (user == null) {
			User newUser = new User();
			newUser.setUserName("赵海豪");
			newUser.setNickName("bigsea");
			newUser.setPassword("123");
			newUser.setCreateDate(new Date());
			newUser.setUpdateDate(new Date());
			userRepository.save(newUser);
		}
		return userRepository.findOne(1);
	}

	@Override
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}
	
	
}
