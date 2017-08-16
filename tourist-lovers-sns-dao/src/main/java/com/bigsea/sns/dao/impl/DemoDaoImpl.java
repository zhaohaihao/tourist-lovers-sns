package com.bigsea.sns.dao.impl;

import org.springframework.stereotype.Repository;

import com.bigsea.sns.dao.DemoDao;
import com.bigsea.sns.model.Demo;
/**
 * Demo DaoImpl
 * Created by zhh on 2017/08/16.
 */
@Repository
public class DemoDaoImpl implements DemoDao {

	@Override
	public Demo getDemo() {
		Demo demo = new Demo();
		demo.setId(1);
		demo.setMsg("Hello World!");
		return demo;
	}

}
