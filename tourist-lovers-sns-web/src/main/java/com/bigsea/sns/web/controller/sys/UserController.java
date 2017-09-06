package com.bigsea.sns.web.controller.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;
import com.bigsea.sns.web.constant.CtrlConstant.ResultField;
import com.bigsea.sns.web.controller.BaseController;

/**
 * Created by zhh on 2017/09/06.
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("findOne")
	@ResponseBody
	public Map<String, Object> findOne() {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> dataMap = new HashMap<>();
		try {
			User user = userService.findOne();
			dataMap.put("user", user);
			resultMap.put(ResultField.DATA, dataMap);
			handleSuc(resultMap);
		} catch (Exception e) {
			handleErr(resultMap, "查询用户失败!", e);
		}
		return resultMap;
	}
	
	@RequestMapping("findUserById/{id}")
	@ResponseBody
	public Map<String, Object> findUserById(@PathVariable Integer id) {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> dataMap = new HashMap<>();
		try {
			User user = userService.findUserById(id);
			dataMap.put("user", user);
			resultMap.put(ResultField.DATA, dataMap);
			handleSuc(resultMap);
		} catch (Exception e) {
			handleErr(resultMap, "查询id用户失败!", e);
		}
		return resultMap;
	}
}
