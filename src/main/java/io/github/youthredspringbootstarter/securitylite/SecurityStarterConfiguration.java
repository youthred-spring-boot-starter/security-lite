package io.github.youthredspringbootstarter.securitylite;

import io.github.youthredspringbootstarter.securitylite.auth.WebConfig;
import io.github.youthredspringbootstarter.securitylite.i.DefaultSecurityInterceptor;
import io.github.youthredspringbootstarter.securitylite.i.SecurityInterceptor;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecurityProp.class)
@ConditionalOnProperty(value = "security.enable", havingValue = "true")
public class SecurityStarterConfiguration {

    @Bean
    public WebConfig webConfig(SecurityProp securityProp, SecurityInterceptor securityInterceptor) {
        return new WebConfig(securityProp, securityInterceptor);
    }

    @Bean
    @ConditionalOnMissingBean
    public SecurityInterceptor securityInterceptor() {
        return new DefaultSecurityInterceptor();
    }
}
