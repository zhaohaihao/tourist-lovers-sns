package com.bigsea.sns.web.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;

/**
 * Created by zhh on 2017/09/06.
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("findOne")
	@ResponseBody
	public User findOne() {
		return userService.findOne();
	}
	
	@RequestMapping("findUserById/{id}")
	@ResponseBody
	public User findUserById(@PathVariable Integer id) {
		return userService.findUserById(id);
	}
}
