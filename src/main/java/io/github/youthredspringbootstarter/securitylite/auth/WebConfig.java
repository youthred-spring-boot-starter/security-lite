package io.github.youthredspringbootstarter.securitylite.auth;

import io.github.youthredspringbootstarter.securitylite.i.SecurityService;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    private final SecurityProp securityProp;
    private final SecurityService securityInterceptor;

    public WebConfig(SecurityProp securityProp, SecurityService securityInterceptor) {
        this.securityProp = securityProp;
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!CollectionUtils.isEmpty(securityProp.getStaticResources())) {
            securityProp.getStaticResources().forEach((handler, locations) -> registry.addResourceHandler(handler).addResourceLocations(locations));
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(securityProp, securityInterceptor));
    }
}
