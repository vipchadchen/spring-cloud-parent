package opst.we.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {

	private static final ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest getRequest() {
		HttpServletRequest request = (HttpServletRequest) threadLocal.get();
		return request;
	}

	public static String getWebRoot() {
		HttpServletRequest request = (HttpServletRequest) threadLocal.get();
		return request.getSession().getServletContext().getRealPath("/");
	}

	public static String getWebPath(String path) {
		HttpServletRequest request = (HttpServletRequest) threadLocal.get();
		return request.getSession().getServletContext().getRealPath(path);
	}

	public static String getWebContextPath() {
		HttpServletRequest request = (HttpServletRequest) threadLocal.get();
		return request.getContextPath();
	}

	public static void setRequest(HttpServletRequest request) {
		threadLocal.set(request);
	}

	public static void r404(HttpServletResponse response) {
		try {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object session(String name) {
		return WebUtils.getRequest().getSession().getAttribute(name);
	}

	public static <T> T getBean(HttpServletRequest request, Class<T> clazz) {
		return WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean(clazz);
	}
	
	public static Object getBean(HttpServletRequest request, String serviceid) {
		return WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()).getBean(serviceid);
	}
	
	public static void session(String name, Object val) {
		WebUtils.getRequest().getSession().setAttribute(name, val);
	}

	public static void removeSession(String name) {
		WebUtils.getRequest().getSession().removeAttribute(name);
	}

	public static void writer(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(str);
		response.flushBuffer();
	}

	public static <T> ResponseEntity<T> getResponseEntity(T t) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<T>(t, headers, HttpStatus.OK);
	}

	public static String getIpAddr() {
		String ip = WebUtils.getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = WebUtils.getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = WebUtils.getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = WebUtils.getRequest().getRemoteAddr();
		}
		return ip;
	}
}
