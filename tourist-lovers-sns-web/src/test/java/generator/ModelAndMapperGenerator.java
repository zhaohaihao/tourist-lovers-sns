package generator;

import static com.bigsea.sns.model.constant.ProjectConstant.MAPPER_PACKAGE;
import static com.bigsea.sns.model.constant.ProjectConstant.MODEL_PACKAGE;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.bigsea.sns.util.base.StringUtils;

/**
 * Model & Mapper 生成器
 * Created by zhh on 2017/09/19.
 */
public class ModelAndMapperGenerator extends CodeGeneratorBaseTool {
	
	/**
	 * 根据表, 自动生成 Model & Mapper
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param 区分字段, 规定如表tls_sys_user, 则sys即为区分字段
	 */
	public static void genModelAndMapper(String tableName, String modelName, String sign) {
		Context context = null;
		try {
			context = InitConfiguration.initMybatisGeneratorContext();
			// TODO 路径转换
			JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
	        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
	        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE + "." + sign);
	        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
	        
	        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
	        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
	        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE + "." + sign);
	        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
	        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
	        
	        TableConfiguration tableConfiguration = new TableConfiguration(context);
	        tableConfiguration.setTableName(tableName);
	        tableConfiguration.setDomainObjectName(modelName);
	        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
	        context.addTableConfiguration(tableConfiguration);
		} catch (Exception e) {
			throw new RuntimeException("ModelAndMapperGenerator 初始化环境异常!", e);
		}
        
        // 主要处理过程, 以上为了单独配置保存路径
        mainGenerator(tableName, modelName, context);
	}
	
	/**
	 * 生成 Model & Mapper 主要过程
	 * @param tableName 表名
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param context 配置内容
	 */
	private static void mainGenerator(String tableName, String modelName, Context context) {
		List<String> warnings = null;
		MyBatisGenerator generator = null;
		try {
			Configuration cfg = new Configuration();
			cfg.addContext(context);
//			cfg.validate();
			
			boolean overwrite = true;
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			warnings = new ArrayList<String>();
			generator = new MyBatisGenerator(cfg, callback, warnings);
			generator.generate(null);
		} catch (Exception e) {
			throw new RuntimeException("Model 和  Mapper 生成失败!", e);
		}
		
		if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
			throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
		}
		
		if (StringUtils.isNullOrEmpty(modelName)) {
			modelName = tableNameConvertUpperCamel(tableName);
		}
		
		logger.info(modelName, "{}.java 生成成功!");
		logger.info(modelName, "{}Mapper.java 生成成功!");
		logger.info(modelName, "{}Mapper.xml 生成成功!");
	}
}
