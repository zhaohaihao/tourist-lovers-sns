package generator;

import static com.bigsea.sns.model.constant.ProjectConstant.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigsea.sns.util.base.StringUtils;
import com.google.common.base.CaseFormat;

/**
 * 代码生成基础工具(JDBC配置 & 路径 & 通用方法...)
 * Created by zhh on 2017/09/18.
 */
public class CodeGeneratorBaseTool {
	
	//=================================== 相关配置 ===================================
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/tourist_lovers_sns";
	protected static final String JDBC_USERNAME = "root";
	protected static final String JDBC_PASSWORD = "root";
	protected static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	protected static final String PROJECT_PATH = System.getProperty("user.dir"); // 项目在硬盘上的基础路径
	protected static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template"; // 模板存放位置

	protected static final String JAVA_PATH = "/src/test/java"; // java文件路径
	protected static final String RESOURCES_PATH = "/src/test/resources"; // 资源文件路径
	
	protected static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE); // 生成的 Service 存放路径
	protected static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE); // 生成的 Service 实现存放路径
	protected static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE); // 生成的 Controller 存放路径

	protected static final String AUTHOR = "zhh"; // @author
	protected static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date()); // @date
	//=================================== 相关配置 ===================================
	
	protected static final Logger logger = LoggerFactory.getLogger(CodeGeneratorBaseTool.class);
	
	/**
	 * 下划线转成驼峰, 首字符为小写
	 * eg: tls_sys_user ==> tblSysUser
	 * @param tableName 表名, eg: tbl_sys_user
	 * @return
	 */
	protected static String tableNameConvertLowerCamel(String tableName) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
	}
	
	/**
	 * 下划线转成驼峰, 首字符为大写
	 * eg: tls_sys_user ==> TblSysUser
	 * @param tableName 表名, eg: tls_sys_user
	 * @return
	 */
	protected static String tableNameConvertUpperCamel(String tableName) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
	}
	
	protected static String tableNameConvertMappingPath(String tableName) {
		tableName = tableName.toLowerCase();
		return File.separator + (tableName.contains("_") ? tableName.replaceAll("_", File.separator) : tableName);
	}
	
	protected static String modelNameConvertMappingPath(String modelName) {
		String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
		return tableNameConvertMappingPath(tableName);
	}
	
	/**
	 * 包转成路径
	 * eg: com.bigsea.sns ==> com/bigsea/sns
	 * @param packageName
	 * @return
	 */
	protected static String packageConvertPath(String packageName) {
		return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
	}
	
	/**
	 * 获取表的区分字段
	 * @param tableName 表名, eg: tls_sys_user
	 * @return 区分字段 eg: sys
	 */
	protected static String getSign(String tableName) {
		return getTableNameSplit(tableName)[1];
	}
	
	/**
	 * 获取默认 modelName
	 * @param tableName 表名
	 * @return
	 */
	protected static String getDefModelName(String tableName) {
		String[] strs = getTableNameSplit(tableName);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < strs.length; i++) {
			sb.append(StringUtils.toUpperCaseFirstOne(strs[i].toLowerCase()));
		}
		return sb.toString();
	}
	
	/**
	 * 获取表名切割后的数组
	 * @param tableName 表名
	 * @return
	 */
	private static String[] getTableNameSplit(String tableName) {
		String[] strs = tableName.split("_");
		if (!tableName.contains("_") || strs.length < 3) {
			throw new RuntimeException("表名格式不正确, 请按规定格式! 例如: tls_sys_user");
		}
		return strs;
	}
}
