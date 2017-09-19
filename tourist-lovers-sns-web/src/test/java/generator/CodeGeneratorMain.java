package generator;
/**
 * 代码生成
 * 根据表名生成对应 Model & Mapper & Service & Controller
 * Created by zhh on 2017/09/18.
 */
public class CodeGeneratorMain extends CodeGeneratorBaseTool {
	
	private static final String TABLE_NAME = "tls_sys_user";
	
	private static final String MODEL_NAME = "IUser";
	
	private static final String[] TABLES = {
			"tls_sys_user", "tls_sys_roles"
	};
	
	/**
	 * 以表名 tls_sys_user 为例子, 主要是以下几种情况
	 * 1. 单表生成:
	 * 		genCode(true, "tls_sys_user");  tls_sys_user ==> User
	 * 		genCode(false, "tls_sys_user"); tls_sys_user ==> TlsSysUser
	 * 		genCode("tls_sys_user", "IUser", false); tls_sys_user ==> IUser
	 * 2. 多表生成:
	 * 		例: String[] tables = { "tls_sys_user", "tls_sys_roles" };
	 * 
	 * 		genCode(true, tables);	tls_sys_user ==> User, tls_sys_roles ==> Roles
	 * 		genCode(false, tables); tls_sys_user ==> TlsSysUser, tls_sys_roles ==> TlsSysRoles
	 */
	public static void main(String[] args) {
		// 1
		genCode(true, TABLE_NAME);
		// 2
//		genCode(false, TABLE_NAME);
		// 3
//		genCode(TABLE_NAME, MODEL_NAME, false);
		// 4
//		genCode(true, TABLES);
		// 5
//		genCode(false, TABLES);
	}
	
	/**
	 * 通过数据库表名, 生成代码
	 * 如表名为 tls_sys_user
	 * 将生成  User & UserMapper & UserService & UserServiceImpl & UserController
	 * @param flag 标志
	 * @param tableNames 表名数组
	 */
	public static void genCode(boolean flag, String ...tableNames) {
		for (String tableName : tableNames) {
			genCode(tableName, null, flag);
		}
	}
	
	/**
	 * 通过数据库表名, 和自定义 modelName 生成代码
	 * 如表名为 tls_sys_user, 自定义 modelName 为 User
	 * 将生成  User & UserMapper & UserService & UserServiceImpl & UserController
	 * @param tableName 表名
	 * @param modelName 实体类名
	 * @param flag 标志
	 */
	public static void genCode(String tableName, String modelName, boolean flag) {
		String sign = getSign(tableName);
		if (flag) {
			modelName = getDefModelName(tableName);
		}
		ModelAndMapperGenerator.genModelAndMapper(tableName, modelName, sign);
		ServiceGenerator.genService(tableName, modelName, sign);
		ControllerGenerator.genController(tableName, modelName, sign);
	}
}
