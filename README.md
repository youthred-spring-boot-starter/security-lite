# Security Lite

> 轻量级接口拦截权限校验

```xml
<properties>
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

- `security.enable` 是否开启
- `security.static-resources` 静态资源键值对 K:Handler V:Locations

配置完成这两项便可支持静态资源访问

### 接口权限配置

- 实现 `io.github.youthredspringbootstarter.securitylite.i.SecurityInterceptor`

    ```java
    public interface SecurityInterceptor {
    
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
    ```