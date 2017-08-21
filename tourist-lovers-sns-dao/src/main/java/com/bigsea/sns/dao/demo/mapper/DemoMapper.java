package com.bigsea.sns.dao.demo.mapper;
import org.apache.ibatis.annotations.Param;

import com.bigsea.sns.model.Demo;
/**
 * Created by zhh on 2017/08/18.
 */
public interface DemoMapper {
	
	Demo get(@Param("username") String username);
}
