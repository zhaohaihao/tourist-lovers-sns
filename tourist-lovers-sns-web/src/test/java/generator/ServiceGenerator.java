package generator;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import static com.bigsea.sns.model.constant.ProjectConstant.*;
import com.bigsea.sns.util.base.StringUtils;

import freemarker.template.Configuration;

/**
 * Service 生成器
 * Created by zhh on 2017/09/19.
 */
public class ServiceGenerator extends CodeGeneratorBaseTool {
	
	/**
	 * 根据表, 自动生成 Service
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param 区分字段, 规定如表tls_sys_user, 则sys即为区分字段
	 */
	public static void genService(String tableName, String modelName, String sign) {
		try {
			Configuration cfg = InitConfiguration.getFreemarkerConfiguration();
			
			Map<String, Object> data = new HashMap<>();
			data.put("date", DATE);
			data.put("author", AUTHOR);
			String modelNameUpperCamel = StringUtils.isNullOrEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
			data.put("sign", sign);
			data.put("modelNameUpperCamel", modelNameUpperCamel);
			data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
			data.put("basePackage", BASE_PACKAGE);
			
			// 创建 Service 接口
			File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + "/" + sign + "/"
					+ modelNameUpperCamel + "Service.java");
			// 查看父级目录是否存在, 不存在则创建
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			cfg.getTemplate("service.ftl").process(data, new FileWriter(file));
			logger.info(modelNameUpperCamel + "Service.java 生成成功!");
			
			// 创建 Service 接口的实现类
			File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + "/" + sign + "/"
					+ modelNameUpperCamel + "ServiceImpl.java");
			// 查看父级目录是否存在, 不存在则创建
			if (!file1.getParentFile().exists()) {
				file1.getParentFile().mkdirs();
			}
			cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(file1));
			logger.info(modelNameUpperCamel + "ServiceImpl.java 生成成功!");
		} catch (Exception e) {
			throw new RuntimeException("Service 生成失败!", e);
		}
	}
}
