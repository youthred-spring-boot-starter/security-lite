package io.github.youthredspringbootstarter.securitylite.auth;

import io.github.youthredspringbootstarter.securitylite.i.SecurityInterceptor;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    private final SecurityProp securityProp;
    private final SecurityInterceptor securityInterceptor;

    public WebConfig(SecurityProp securityProp, SecurityInterceptor securityInterceptor) {
        this.securityProp = securityProp;
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (CollectionUtils.isEmpty(securityProp.getStaticResource())) {
            securityProp.getStaticResource().forEach((handler, locations) -> registry.addResourceHandler(handler).addResourceLocations(locations));
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(securityProp, securityInterceptor));
    }
}
