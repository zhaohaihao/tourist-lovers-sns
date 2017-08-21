package com.bigsea.sns.service.impl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigsea.sns.dao.demo.mapper.DemoMapper;
import com.bigsea.sns.dao.demo.repository.DemoRepository;
import com.bigsea.sns.model.Demo;
import com.bigsea.sns.service.demo.DemoService;
/**
 * Demo ServiceImpl
 * Created by zhh on 2017/08/16.
 */
@Service
@Transactional
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	DemoMapper demoMapper;
	
	@Autowired
	DemoRepository demoRepository;
	
	@Override
	public Demo getDemoByRepo() {
		Demo demo = demoRepository.findOne(1);
		if (demo == null) {
			Demo newDemo = new Demo();
			newDemo.setUsername("赵海豪");
			newDemo.setAge(23);
			demoRepository.save(newDemo);
		}
		return demoRepository.findOne(1);
	}

	@Override
	public Demo getDemoByMapper() {
		Demo demo = demoMapper.get("赵海豪");
		return demo;
		
	}

}
