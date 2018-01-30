package opst.we.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象属性处理
 * @author Chad
 *
 */
public class ReflectUtil {
	
	public static Object getClassField(Object obj, String name) throws Exception {
		Field field = getField(obj.getClass(), name);
		return field.get(obj);
	}
	
	public static void setClassField(Object obj, String name, Object value) throws Exception {
		Field field = getField(obj.getClass(), name);
		field.set(obj, value);
	}
	
	public static Object getSuperClassField(Object obj, String name) throws Exception {
		Field field = getField(obj.getClass().getSuperclass(), name);
		return field.get(obj);
	}
	
	private static Field getField(Class<?> clazz, String name) throws Exception {
		Field field = null;
		for(Field f : clazz.getDeclaredFields()) {
			if(f.getName().equals(name)) {
				f.setAccessible(true);
				field = f;
				break;
			}
		}
		return field;
	}
	
	/**
	 * 获取对象属性名称和数据类型
	 * @param o
	 * @return
	 */
	public static List<Map<String, String>> getFiledsInfo(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
//		String[] fieldNames = new String[fields.length];
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap<String, String>();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
//			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();
		StringBuffer buffer3 = new StringBuffer();
//		UserInfo userInfo = new UserInfo();
		List<Map<String, String>> list = getFiledsInfo(null);
		for (Map<String, String> map : list) {
			for (String key : map.keySet()) {
				if("name".equals(key)){
					buffer.append("\""+map.get(key)+"\",");
					buffer2.append("\"in\",");
					buffer3.append("\"\",");
				}else if("type".equals(key)){
					if(map.get(key).contains("int")){
						buffer1.append("\"I\",");
					}else if(map.get(key).contains("String")){
						buffer1.append("\"S\",");
					}else {
						buffer1.append("\"S\",");
					}
				}
			}
		}
		System.out.println(buffer.toString());
		System.out.println(buffer1.toString());
		System.out.println(buffer2.toString());
		System.out.println(buffer3.toString());
	}

}