package io.github.youthredspringbootstarter.securitylite.o;

import org.springframework.http.HttpMethod;

public class SecurityServlet {

    /**
     * API唯一ID
     */
    private String id;
    private HttpMethod method;
    /**
     * 支持RestFul风格
     */
    private String path;

    public String getId() {
        return id;
    }

    public SecurityServlet setId(String id) {
        this.id = id;
        return this;
    }

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
}
