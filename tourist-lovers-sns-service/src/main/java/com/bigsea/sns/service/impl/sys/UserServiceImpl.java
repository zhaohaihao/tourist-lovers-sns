package com.bigsea.sns.service.impl.sys;

import com.bigsea.sns.dao.mapper.sys.UserMapper;
import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;
import com.bigsea.sns.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 *
 * Created by zhh on 2017/09/28.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper tlsSysUserMapper;

}
