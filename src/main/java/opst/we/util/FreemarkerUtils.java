package opst.we.util;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtils {

	private static Configuration config = new Configuration();
	{
		config.setClassForTemplateLoading(FreemarkerUtils.class, "/");
		config.setObjectWrapper(new DefaultObjectWrapper());
		config.setNumberFormat("#");
	}

	private static Configuration webConfig = new Configuration();
	{
		webConfig.setObjectWrapper(new DefaultObjectWrapper());
		webConfig.setNumberFormat("#");
	}

	/**
	 * 在freemarker 查找 枚举类型
	 * 
	 * @return
	 */
	public static TemplateModel getEnumTemplateModel(Class<?> menu_clazz) {
		try {
			BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
			TemplateHashModel enumModels = wrapper.getEnumModels();
			return enumModels.get(menu_clazz.getName());
		} catch (TemplateModelException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 在freemarker 查找 静态类型
	 * 
	 * @return
	 */
	public static TemplateModel getStaticTemplateModel(Class<?> clazz) {
		try {
			BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
			TemplateHashModel enumModels = wrapper.getStaticModels();
			return enumModels.get(clazz.getName());
		} catch (TemplateModelException e) {
			throw new RuntimeException(e);
		}
	}

	public static String webProcess(String template, Map<String, Object> params) {
		StringWriter out = new StringWriter();
		try {
			String path = WebUtils.getRequest().getSession().getServletContext().getRealPath("/WEB-INF/view");
			webConfig.setDirectoryForTemplateLoading(new File(path));
			Template temp = webConfig.getTemplate(template,"UTF-8");
			temp.process(params, out);
			return out.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
//				logger.error("IOException",e);
			}
		}
		return "";
	}

	public static String process(String template, Map<String, Object> params) {
		StringWriter out = new StringWriter();
		try {
			Template temp = config.getTemplate(template,"UTF-8");
			temp.process(params, out);
			return out.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
//				logger.error("IOException",e);
			}
		}
		return "";
	}
}
