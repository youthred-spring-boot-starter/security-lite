package io.github.youthredspringbootstarter.securitylite;

import io.github.youthredspringbootstarter.securitylite.auth.WebConfig;
import io.github.youthredspringbootstarter.securitylite.i.DefaultSecurityService;
import io.github.youthredspringbootstarter.securitylite.i.SecurityService;
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
    public WebConfig webConfig(SecurityProp securityProp, SecurityService securityInterceptor) {
        return new WebConfig(securityProp, securityInterceptor);
    }

    @Bean
    @ConditionalOnMissingBean
    public SecurityService securityService() {
        return new DefaultSecurityService();
    }
}
