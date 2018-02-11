package opst.we.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Arequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public Arequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	public String getSqlStr(String str) {
		return str.replaceAll("'", "''");
	}

	public int getIntParam(String key) {
		return this.getIntParam(key, 0);
	}

	public long getLongParam(String key) {
		return this.getLongParam(key, 0);
	}

	public String getStrParam(String key, boolean isget) {
		if (isget)
			return this.getGetChStr(this.getStrParam(key));
		else
			return this.getStrParam(key);
	}

	public String getStrParam(String key) {
		return this.getStrParam(key, "");
	}

	public float getFloatParam(String key) {
		return this.getFloatParam(key, 0);
	}

	public Date getDateParam(String key) {
		return this.getDateParam(key, null);
	}

	public Double getDoubleParam(String key) {
		return this.getDoubleParam(key, 0);
	}

	public Date getDateParam(String key, Date _default) {
		try {
			if (key != null && !key.trim().equals("")) {
				return DateUtil.stringToDate(key);
			} else {
				return _default;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public double getDoubleParam(String key, double _default) {
		try {
			return Double.parseDouble(this.getStrParam(key, String.valueOf(_default)));
		} catch (Exception e) {
			return 0;
		}
	}

	public float getFloatParam(String key, float _default) {
		try {
			return Float.parseFloat(this.getStrParam(key, String.valueOf(_default)));
		} catch (Exception e) {
			return 0;
		}
	}

	public int getIntParam(String key, int _default) {
		try {
			return Integer.parseInt(this.getStrParam(key, String.valueOf(_default)));
		} catch (Exception e) {
			return 0;
		}
	}

	public long getLongParam(String key, long _default) {
		try {
			return Long.parseLong(this.getStrParam(key, String.valueOf(_default)));
		} catch (Exception e) {
			return 0;
		}
	}

	private Object getParam(String key, Object _default) {
		String value = request.getParameter(key);
		if (value == null)
			return _default;
		if (value.equals(""))
			return _default;
		return value;
	}

	public String getGetChStr(String value) {
		try {
			return new String(value.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getStrParam(String key, String _default) {
		return this.getParam(key, _default).toString();
	}

	public String getCurrentUrl() {
		String query = request.getQueryString();
		if (StringUtils.isEmpty(query))
			return "";
		else {
			return request.getRequestURL().toString() + "?" + this.getGetChStr(query);
		}
	}

	public String getCurrentUrl(String concat) {
		String query = request.getQueryString();
		if (StringUtils.isEmpty(query))
			return concat;
		else {
			return request.getRequestURL().toString() + concat + "?" + this.getGetChStr(query);
		}
	}

	public String getCurrentPage() {
		String url = request.getRequestURL().toString();
		String[] items = url.split("/");
		return items[items.length - 1];
	}

	public String getRefferUrl() {
		return request.getHeader("Referer");
	}

	public Map<String, String> getParam(String param) {
		Map<String, String> map = new HashMap<String, String>();
		String[] params = param.split("&");
		for (String pm : params) {
			String[] name = pm.split("=");
			if (name.length > 1) {
				map.put(name[0], name[1]);
			} else if (name.length == 1) {
				map.put(name[0], "");
			}
		}
		return map;
	}

	public String getParam(Map<String, String> map) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			builder.append(entry.getKey() + "=" + entry.getValue() + "&");
		}
		builder.replace(builder.length() - 1, builder.length(), "");
		return builder.toString();
	}

	public String getPageUrl(String param) {
		if (param != null) {
			String query = this.request.getQueryString();
			if (query == null) {
				return this.request.getRequestURI().toString() + "?" + param;
			}
			String paramurl = getGetChStr(query) + "&" + param;
			return this.request.getRequestURI().toString() + "?" + getParam(getParam(paramurl));
		}
		return getCurrentUrl();
	}

	public String getPageUrl(String param, String path) {
		if (param != null) {
			String query = this.request.getQueryString();
			if (query == null)
				return path + "?" + param;

			String paramurl = getGetChStr(query) + "&" + param;
			return path + "?" + getParam(getParam(paramurl));
		}
		return getCurrentUrl();
	}

	/**
	 * 获得请求前缀
	 * 
	 * @param url
	 * @return
	 */
	public String getPrefixUrl(String url) {
		String result = "";
		int index = url.indexOf("/");
		url = url.substring(index + 1);
		int secondIndex = url.indexOf("/");
		url = url.substring(0, secondIndex);
		result = "/" + url;
		return result;
	}

	@SuppressWarnings("all")
	public Map<String, String> getRequestMap() {
		Map<String, String[]> reqParam = request.getParameterMap();
		Map<String, String> param = new HashMap<String, String>(reqParam.size());
		for (String key : reqParam.keySet()) {
			param.put(key, reqParam.get(key)[0]);
		}
		return param;
	}

	public String getSessionId() {
		return request.getSession().getId();
	}
}
