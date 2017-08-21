package com.bigsea.sns.dao.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigsea.sns.model.Demo;
/**
 * Created by zhh on 2017/08/21.
 */
public interface DemoRepository extends JpaRepository<Demo, Integer> {
	
}
