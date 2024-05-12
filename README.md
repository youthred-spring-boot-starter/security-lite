# Security Lite

> 轻量级接口拦截权限校验

```xml
<properties>
    <!-- 2.x only -->
    <springboot.version>2.7.18</springboot.version>
</properties>
```

```xml
<dependency>
    <groupId>io.github.youthred-spring-boot-starter</groupId>
    <artifactId>security-lite</artifactId>
</dependency>
```

## Usage

### Properties

```yaml
security:
  enable: true
  static-resources:
    "/**":
      - "classpath:static/"
      - "file:/home/tmp/"
      - "file:D:/tmp/"
```

- `security.enable` 是否启用
- `security.static-resources` 静态资源键值对 K:Handler V:Locations

配置完成这两项便可支持静态资源访问

### 接口权限配置

- 实现 `io.github.youthredspringbootstarter.securitylite.i.SecurityService`

    ```java
    /**
    * 需要拦截的接口
    *
    * @return 需要拦截的接口
    */
    List<SecurityServlet> interceptions();
    ```

- 实现 `io.github.youthredspringbootstarter.securitylite.i.LoginService`
    ```java
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
    ```