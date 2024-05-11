package io.github.youthredspringbootstarter.securitylite.auth;

import io.github.youthredspringbootstarter.securitylite.i.LoginService;
import io.github.youthredspringbootstarter.securitylite.i.SecurityService;
import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    private final static PathMatcher PATH_MATCHER = new AntPathMatcher();

    private final SecurityProp securityProp;
    private final SecurityService securityService;
    private final LoginService loginService;

    public AuthInterceptor(SecurityProp securityProp, SecurityService securityService, LoginService loginService) {
        this.securityProp = securityProp;
        this.securityService = securityService;
        this.loginService = loginService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!securityProp.isEnable()) {
            return true;
        }
        if (CollectionUtils.isEmpty(securityService.interceptions())) {
            return true;
        }
        String servletMethod = request.getMethod();
        String servletPath = request.getServletPath();
        for (SecurityServlet ss : securityService.interceptions()) {
            if (PATH_MATCHER.match(servletPath, ss.getPath()) && ss.getMethod().name().equals(servletMethod)) {
                // todo 角色权限验证
                return loginService.verity(ss, "", request);
            }
        }

        return false;
    }
}
