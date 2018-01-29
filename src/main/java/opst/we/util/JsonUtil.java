package opst.we.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.List;
import java.util.Map;

public class JsonUtil {

	/**
	 * MSG
	 */
	private static String MSG = "成功";

	/**
	 * dateConfig
	 */
	private static SerializeConfig dateConfig = new SerializeConfig();

	/**
	 * 构造
	 */
	private JsonUtil() {
		super();
	}

	static {
		dateConfig.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
		dateConfig.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
		dateConfig.put(java.sql.Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 将object对象转化为json打印出来
	 * 
	 * @param object
	 *            object
	 * @param response
	 *            response
	 * @throws Exception
	 *             Exception
	 */
	public static void printJsonToPage(Object object, HttpServletResponse response) throws Exception {
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.write(object);
		out.writeTo(response.getWriter());
	}


	/**
	 * 将object对象转化为json打印出来
	 * 
	 * @param object
	 *            object
	 * @param response
	 *            response
	 * @throws Exception
	 *             Exception
	 */
	public static void printJsonToPageParseDate(Object object, HttpServletResponse response) throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		bos.write(JSON.toJSONBytes(object, dateConfig));
		bos.flush();
	}

	/**
	 * 把一个对象转换为 JSON<br>
	 * 
	 * @param obj
	 *            obj
	 * @return JSON
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, dateConfig);
	}
	
	/**
	 * 把一个对象转换为 JSON字符串并且不忽略为NULL值的属性<br>
	 * 
	 * @param obj
	 *            
	 * @return JSON
	 */
	public static String toJsonUnIgnoreNull(Object obj) {
		return JSON.toJSONString(obj, dateConfig, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty).replaceAll(":null,", ":\"\",");
	}
	
	/**
	 * 把string转换为 JSON对象
	 * @param str
	 * @return
	 */
	public static JSONObject toJson(String str) {
		return JSON.parseObject(str);
	}
	
	/**
	 * 把string转换为 JSON数组
	 * @param str
	 * @return
	 */
	public static JSONArray toJsonArr(String str) {
		return JSON.parseArray(str);
	}

	/**
	 * 把一个json 数组转换为 list<br>
	 * 
	 * @param json
	 *            json
	 * @param clazz
	 *            clazz
	 * @param <T>
	 *            class
	 * @return List<T>
	 */
	public static <T> List<T> toArray(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}

	/**
	 * 把一个json 数组转换为 Object<br>
	 * 
	 * @param json
	 *            json
	 * @param clazz
	 *            clazz
	 * @param <T>
	 *            class
	 * @return T
	 */
	public static <T> T toObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	/**
	 * 把一个json 为 Map<br>
	 * 
	 * @param json
	 * @return map
	 */
	public static Map<?, ?> toMap(String json) {
		return (Map<?, ?>) JSON.parse(json);
	}
	/**
	 * 判断字符串是否json格式
	 * @param json
	 * @return JSON_TYPE_ERROR 不是json格式
	 * 		   JSON_TYPE_OBJECT json对象
	 * 		   JSON_TYPE_ARRAY json数组
	 */
	public static String getJSONType(String json) {
		if(StringUtils.isEmpty(json)){
			return "JSON_TYPE_ERROR";
		}
		final char[] strChar = json.substring(0, 1).toCharArray();
		final char firstChar = strChar[0];
		if(firstChar == '{'){
            return "JSON_TYPE_OBJECT";
        }else if(firstChar == '['){
            return "JSON_TYPE_ARRAY";
        }else{
            return "JSON_TYPE_ERROR";
        }
	}
	
	public static void main(String[] args) {
		JSONObject json = toJson("{\"state\":\"100020\",\"message\":\"参数格式不正确！\"}");
		System.out.println(json.get("message"));
	}

}
