package io.github.youthredspringbootstarter.securitylite.auth;

import io.github.youthredspringbootstarter.securitylite.i.SecurityInterceptor;
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
    private final SecurityInterceptor securityInterceptor;

    public AuthInterceptor(SecurityProp securityProp, SecurityInterceptor securityInterceptor) {
        this.securityProp = securityProp;
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!securityProp.isEnable()) {
            return true;
        }
        if (CollectionUtils.isEmpty(securityInterceptor.interceptions())) {
            return true;
        }
        String servletMethod = request.getMethod();
        String servletPath = request.getServletPath();
        for (SecurityServlet ss : securityInterceptor.interceptions()) {
            if (PATH_MATCHER.match(servletPath, ss.getPath()) && ss.getMethod().name().equals(servletMethod)) {
                // todo 角色权限验证
                return true;
            }
        }

        return false;
    }
}
