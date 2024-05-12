package io.github.youthredspringbootstarter.securitylite.i;

import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    /**
     * 登录校验并颁发令牌
     *
     * @param request 登录请求
     * @return TOKEN
     * @throws Exception e
     */
    String sign(ServerRequest request) throws Exception;

    /**
     * 当有接口访问被拦截的API时便会调用此方法进行验证
     *
     * @param securityServlet 拦截API
     * @param token           登录令牌
     * @param request         Servlet请求对象
     * @return 是否放行
     * @throws Exception e
     */
    boolean verity(SecurityServlet securityServlet, String token, HttpServletRequest request) throws Exception;
}
