package opst.we.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	private BeanUtils() {
	}

	static {
		// 注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
		ConvertUtils.register(new SqlDateConverter(), java.util.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
		// 注册util.date的转换器，即允许BeanUtils.copyProperties时的源目标的util类型的值允许为空
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
	}

	public static void copyProperties(Object target, Object source) throws InvocationTargetException, IllegalAccessException {
		// 支持对日期copy
		BeanUtils.copyProperties(target, source);

	}
	

	/**
	 * 设置属性的值
	 * 
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static Field setValue(Object bean, String name, Object value) {
		try {
			Class<?> clazz = bean.getClass();
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			field.set(bean, value);
			return field;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过对象的属性名 获得属性值
	 * 
	 * @param bean
	 * @param name
	 * @return
	 */
	public static Object getValue(Object bean, String name) {
		try {
			Class<?> clazz = bean.getClass();
			String[] names = name.split("\\.");
			for (String na : names) {
				bean = clazz.getMethod("get" + StringUtils.capitalize(na)).invoke(bean);
				clazz = bean.getClass();
			}
			return bean;
		} catch (Exception e) {
			return null;
		}
	}

}
