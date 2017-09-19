package generator;

import static com.bigsea.sns.model.constant.ProjectConstant.BASE_PACKAGE;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.bigsea.sns.util.base.StringUtils;
import com.google.common.base.CaseFormat;

import freemarker.template.Configuration;

/**
 * Controller 生成器
 * Created by zhh on 2017/09/19.
 */
public class ControllerGenerator extends CodeGeneratorBaseTool {

	/**
	 * 根据表, 自动生成 Controller
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param 区分字段, 规定如表tls_sys_user, 则sys即为区分字段
	 */
	public static void genController(String tableName, String modelName, String sign) {
		try {
			Configuration cfg = InitConfiguration.getFreemarkerConfiguration();
			
			Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isNullOrEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("sign", sign);
            data.put("baseRequestMapping", StringUtils.toLowerCaseFirstOne(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER+ "/" + sign + "/"
					 + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));

            logger.info(modelNameUpperCamel + "Controller.java 生成成功!");
		} catch (Exception e) {
			throw new RuntimeException("Controller 生成失败!", e);
		}
	}
}
