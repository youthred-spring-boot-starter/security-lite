package io.github.youthredspringbootstarter.securitylite.auth;

import io.github.youthredspringbootstarter.securitylite.i.LoginService;
import io.github.youthredspringbootstarter.securitylite.i.SecurityService;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    private final SecurityProp securityProp;
    private final SecurityService securityService;
    private final LoginService loginService;

    public WebConfig(SecurityProp securityProp, SecurityService securityService, LoginService loginService) {
        this.securityProp = securityProp;
        this.securityService = securityService;
        this.loginService = loginService;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!CollectionUtils.isEmpty(securityProp.getStaticResources())) {
            securityProp.getStaticResources().forEach((handler, locations) -> registry.addResourceHandler(handler).addResourceLocations(locations));
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(securityProp, securityService, loginService));
    }
}
