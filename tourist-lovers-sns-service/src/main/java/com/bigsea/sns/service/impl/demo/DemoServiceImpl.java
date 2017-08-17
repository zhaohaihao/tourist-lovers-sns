package com.bigsea.sns.service.impl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigsea.sns.dao.demo.DemoDao;
import com.bigsea.sns.model.Demo;
import com.bigsea.sns.service.demo.DemoService;
/**
 * Demo ServiceImpl
 * Created by zhh on 2017/08/16.
 */
@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	DemoDao demoDao;
	
	@Override
	public Demo getDemo() {
		return demoDao.getDemo();
	}

}
