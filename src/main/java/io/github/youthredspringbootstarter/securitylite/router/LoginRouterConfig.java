package io.github.youthredspringbootstarter.securitylite.router;

import io.github.youthredspringbootstarter.securitylite.i.LoginService;
import io.github.youthredspringbootstarter.securitylite.o.Login;
import io.github.youthredspringbootstarter.securitylite.prop.SecurityProp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
@EnableConfigurationProperties(SecurityProp.class)
@ConditionalOnProperty(value = "security.login.enable", havingValue = "true")
public class LoginRouterConfig {

    @Bean
    @ConditionalOnMissingBean
    public LoginService loginService() {
        return new LoginService() {
            @Override
            public String verify(Login login) {
                return "";
            }
        };
    }

    @Bean
    public RouterFunction<ServerResponse> loginRouterFunction(LoginService loginService) {
        return RouterFunctions.route().POST("/login", request -> {
            Login login = request.body(Login.class);
            String token = loginService.verify(login);
            return ServerResponse.ok().body(token);
        }).build();
    }
}
