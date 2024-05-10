package io.github.youthredspringbootstarter.securitylite.i;

import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;

import java.util.List;

public interface SecurityService {

    /**
     * 直接放行的接口，不需要填写roles
     *
     * @return 放行的接口
     */
    List<SecurityServlet> releases();

    /**
     * 需要拦截的接口
     *
     * @return 需要拦截的接口
     */
    List<SecurityServlet> interceptions();
}
