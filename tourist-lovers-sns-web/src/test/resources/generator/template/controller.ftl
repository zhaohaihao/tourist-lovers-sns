package ${basePackage}.web.controller.${sign};
import ${basePackage}.model.result.Result;
import ${basePackage}.model.${sign}.${modelNameUpperCamel};
import ${basePackage}.service.${sign}.${modelNameUpperCamel}Service;
import ${basePackage}.web.controller.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *
 * Created by ${author} on ${date}.
 */
@Controller
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller extends BaseController {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @RequestMapping("add")
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return handleSuc();
    }

    @RequestMapping("delete")
    public Result delete(@RequestParam Integer id) {
	    ${modelNameLowerCamel}Service.deleteById(id);
    	return handleSuc();
    }

    @RequestMapping("update")
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    	return handleSuc();
    }

    @RequestMapping("detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return handleSuc(${modelNameLowerCamel});
    }

    @RequestMapping("list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return handleSuc(pageInfo);
    }
}
