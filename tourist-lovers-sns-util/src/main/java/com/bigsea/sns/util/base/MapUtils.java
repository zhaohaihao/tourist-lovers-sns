package com.bigsea.sns.util.base;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 映射操作常用方法集
 * Created by zhh on 2017/08/16.
 */
public class MapUtils {
	
	/**
	 * 映射对象是否为无效值
	 * @param map 要判断的映射
	 * @return 是否为有效值
	 */
	public static boolean isNullOrEmpty(Map map) {
		return map == null || map.isEmpty();
	}
	
	/**
	 * 实体对象转成Map
	 * @param obj 实体对象
	 * @return
	 */
	public static Map<String, Object> object2Map(Object obj) {
		Map<String, Object> map = new HashMap<>();
		if (obj == null) {
			return map;
		}
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * Map转成实体对象
	 * @param map map实体对象包含属性
	 * @param clazz 实体对象类型
	 * @return
	 */
	public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
		if (map == null) {
			return null;
		}
		Object obj = null;
		try {
			obj = clazz.newInstance();
			
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}
				field.setAccessible(true);
				field.set(obj, map.get(field.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	/**
	 * 除去Map对象中 值为空或者空字符串 的键值对
	 * @param map map对象
	 * @return
	 */
	public static Map<String, Object> removeEmptyValue(Map<String, Object> map) {
		Map<String, Object> newMap = new HashMap<>();
		if (map == null) {
			return newMap;
		}
		map.entrySet().stream().filter(entry -> StringUtils.isNullOrEmpty(entry.getValue())).forEach(entry -> {
			newMap.put(entry.getKey(), entry.getValue());
		});
		return newMap;
	}
}
