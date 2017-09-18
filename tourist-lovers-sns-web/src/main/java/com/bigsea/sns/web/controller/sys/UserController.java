package com.bigsea.sns.web.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigsea.sns.model.result.Result;
import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;
import com.bigsea.sns.web.controller.BaseController;

/**
 * Created by zhh on 2017/09/06.
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("findUserById/{id}")
	@ResponseBody
	public Result findUserById(@PathVariable Integer id) {
		try {
			User user = userService.findById(id);
			return handleSuc(user);
		} catch (Exception e) {
			return handleErr("查询id用户失败!");
		}
	}
}
