package com.bigsea.sns.web.controller.sys;
import com.bigsea.sns.model.result.Result;
import com.bigsea.sns.model.sys.User;
import com.bigsea.sns.service.sys.UserService;
import com.bigsea.sns.web.controller.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *
 * Created by zhh on 2017/09/28.
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {

    @Autowired
    UserService userService;
    
    @RequestMapping("index")
    public String index() {
        return "index";
    }
    
    @RequestMapping("error")
    public String error() {
        return "404";
    }
    
    @RequestMapping("add")
    @ResponseBody
    public Result add(User user) {
        userService.save(user);
        return handleSuc();
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(@RequestParam Integer id) {
	    userService.deleteById(id);
    	return handleSuc();
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(User user) {
	    userService.update(user);
    	return handleSuc();
    }

    @RequestMapping("detail")
    @ResponseBody
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return handleSuc(user);
    }

    @RequestMapping("list")
    @ResponseBody
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return handleSuc(pageInfo);
    }
}
