package com.bigsea.sns.web.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigsea.sns.model.Demo;
import com.bigsea.sns.service.demo.DemoService;

/**
 * Demo Controller
 * Created by zhh on 2017/08/16.
 */
@Controller
@RequestMapping("/demo/")
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("getDemoByRepo")
	@ResponseBody
	public Demo getDemoByRepo() {
		return demoService.getDemoByRepo();
	}
	
	@RequestMapping("getDemoByMapper")
	@ResponseBody
	public Demo getDemoByMapper() {
		return demoService.getDemoByMapper();
	}
}
