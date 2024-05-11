package io.github.youthredspringbootstarter.securitylite.i;

import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;

import java.util.List;

public interface SecurityService {

//    /**
//     * 直接放行的API
//     *
//     * @return 放行的API
//     */
//    List<SecurityServlet> releases();

    /**
     * 需要拦截的API
     *
     * @return 需要拦截的API
     */
    List<SecurityServlet> interceptions();
}
