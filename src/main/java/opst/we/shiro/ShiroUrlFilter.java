package opst.we.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ShiroUrlFilter extends AuthorizationFilter {


	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if (isLoginRequest(request, response)) {
			return true;
		}
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated()) {
			return false;
		}

		// 是否对应 ShiroDbRealm 中doGetAuthorizationInfo方法
		if (isUnauthorizedRequest(request)) {
			return true;
		}
		String requestURI = getPathWithinApplication(request);

		if (isPermitted(requestURI)) {
			return true;
		}
		return false;
	}
	
	
	private boolean isUnauthorizedRequest(ServletRequest request) {
		return pathsMatch(getUnauthorizedUrl(), request);
	}

	public boolean isPermitted(String permitted) {
		return SecurityUtils.getSubject().isPermitted(permitted);
	}
}
