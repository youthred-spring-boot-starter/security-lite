package io.github.youthredspringbootstarter.securitylite;

import io.github.youthredspringbootstarter.securitylite.auth.WebConfig;
import io.github.youthredspringbootstarter.securitylite.i.LoginService;
import io.github.youthredspringbootstarter.securitylite.i.SecurityService;
import io.github.youthredspringbootstarter.securitylite.o.SecurityServlet;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableConfigurationProperties(SecurityProp.class)
@ConditionalOnProperty(value = "security.enable", havingValue = "true")
public class SecurityStarterConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SecurityService securityService() {
        return new SecurityService() {
            @Override
            public List<SecurityServlet> releases() {
                return Collections.emptyList();
            }

            @Override
            public List<SecurityServlet> interceptions() {
                return Collections.emptyList();
            }
        };
    }

    @Bean
    public WebConfig webConfig(SecurityProp securityProp, SecurityService securityService, LoginService loginService) {
        return new WebConfig(securityProp, securityService, loginService);
    }
}
