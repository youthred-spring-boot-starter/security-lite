package io.github.youthredspringbootstarter.securitylite.i;

import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;

import java.util.Collections;
import java.util.List;

public class DefaultSecurityInterceptor implements SecurityInterceptor {

    @Override
    public List<SecurityServlet> releases() {
        return Collections.emptyList();
    }

    @Override
    public List<SecurityServlet> interceptions() {
        return Collections.emptyList();
    }
}
