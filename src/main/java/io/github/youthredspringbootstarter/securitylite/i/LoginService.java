package io.github.youthredspringbootstarter.securitylite.i;

import io.github.youthredspringbootstarter.securitylite.o.Login;

public interface LoginService {

    /**
     * 登录校验
     *
     * @param login 登录参数
     * @return TOKEN
     */
    String verify(Login login);
}
