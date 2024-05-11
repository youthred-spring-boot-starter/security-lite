package io.github.youthredspringbootstarter.securitylite.i;

import org.springframework.web.servlet.function.ServerRequest;

public interface LoginService {

    /**
     * 登录校验
     *
     * @param request 登录请求
     * @return TOKEN
     */
    String verify(ServerRequest request) throws Exception;
}
