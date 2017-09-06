package com.bigsea.sns.dao.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bigsea.sns.model.sys.User;
/**
 * Created by zhh on 2017/09/06.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
