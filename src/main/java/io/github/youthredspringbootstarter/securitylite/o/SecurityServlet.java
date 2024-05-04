package io.github.youthredspringbootstarter.securitylite.o;

import org.springframework.http.HttpMethod;

import java.util.List;

public class SecurityServlet {

    private HttpMethod method;
    /**
     * 支持RestFul风格
     */
    private String path;
    /**
     * 放行的角色
     */
    public List<String> roles;

    public HttpMethod getMethod() {
        return method;
    }

    public SecurityServlet setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public String getPath() {
        return path;
    }

    public SecurityServlet setPath(String path) {
        this.path = path;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public SecurityServlet setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }
}
