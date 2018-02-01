package opst.we.filter;

import opst.we.util.Arequest;
import opst.we.util.FreemarkerUtils;
import opst.we.util.StringUtils;
import opst.we.util.WebUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

	public String respath = "/we/res";

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// String uri =
		// request.getRequestURI().replace(request.getContextPath(), "");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(modelAndView != null){
			if(modelAndView.getModelMap().get("msg") != null){
				modelAndView.getModelMap().put("msg", URLEncoder.encode(modelAndView.getModelMap().get("msg").toString(), "utf-8"));
			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		WebUtils.setRequest(request);

		request.setAttribute("now", new Date());
//		request.setAttribute("URL", FreemarkerUtils.getStaticTemplateModel(URLUtils.class));
		request.setAttribute("String", FreemarkerUtils.getStaticTemplateModel(StringUtils.class));
		request.setAttribute("req", new Arequest(request));
//		request.setAttribute("DBConfigs", DBConfig.getConfig());
//		request.setAttribute("Global", Global.getConfig());

		String ctx = request.getContextPath();
		String res = getRespath();
		String url = request.getRequestURL().toString();
		request.setAttribute("ctx", ctx);
		request.setAttribute("url", url);
		request.setAttribute("res", res);
		request.setAttribute("js", res + "/js");
		request.setAttribute("css", res + "/css");
		request.setAttribute("fonts", res + "/fonts");
		request.setAttribute("images", res + "/images");
		return true;
	}

	/**
	 * @return the respath
	 */
	public String getRespath() {
		return respath;
	}

	/**
	 * @param respath the respath to set
	 */
	public void setRespath(String respath) {
		this.respath = respath;
	}

	

}