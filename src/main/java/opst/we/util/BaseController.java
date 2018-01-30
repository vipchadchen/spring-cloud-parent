package opst.we.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public abstract class BaseController {


	/**
	 * 日期类型转换器
	 * 
	 * @param dataBinder
	 *            数据Binder
	 */
	@InitBinder
	public void initDateBinder(WebDataBinder dataBinder) {
		// 日期转换
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				try {
					if (value != null && !value.isEmpty()) {
						setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
					} else {
						setValue(null);
					}
				} catch (ParseException e) {
					try {
						setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}

			public String getAsText() {
				if (getValue() != null) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) getValue());
				} else {
					return null;
				}
			}
		});
		// 字符串去空格
		dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (value != null) {
					setValue(value.trim());
				} else {
					setValue(null);
				}
			}
			public String getAsText() {
				return (String) getValue();
			}
		});
	}

	/**
	 * 重定向到一个url
	 * 
	 * @param url
	 * @return
	 */
	protected String sendRedirect(String url) {
		return "redirect:" + url;
	}

	/**
	 * @param 获得一个视图
	 * @return
	 */
	public abstract String getView(String view);
}