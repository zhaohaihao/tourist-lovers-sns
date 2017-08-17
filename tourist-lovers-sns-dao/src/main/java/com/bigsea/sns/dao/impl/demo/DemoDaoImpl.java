package com.bigsea.sns.dao.impl.demo;

import org.springframework.stereotype.Repository;

import com.bigsea.sns.dao.demo.DemoDao;
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
		demo.setUsername("赵海豪");
		demo.setAge(23);
		return demo;
	}

}
