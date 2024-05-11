package io.github.youthredspringbootstarter.securitylite.router;

import io.github.youthredspringbootstarter.securitylite.i.LoginService;
import io.github.youthredspringbootstarter.securitylite.o.Login;
import io.github.youthredspringbootstarter.securitylite.prop.LoginProp;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class LoginRouterConfig {

    @Bean
    @ConditionalOnMissingBean
    public LoginService loginService() {
        return new LoginService() {
            @Override
            public String sign(ServerRequest request) throws Exception {
                Login login = request.body(Login.class);
                System.out.println(login);
                return "NONE_TOKEN";
            }
        };
    }

    @Bean
    public RouterFunction<ServerResponse> loginRouterFunction(LoginProp loginProp, LoginService loginService) {
        if (!loginProp.isEnable()) {
            return RouterFunctions.route().build();
        }
        return RouterFunctions.route().POST("/login", request -> {
            String token = loginService.sign(request);
            return ServerResponse.ok().body(token);
        }).build();
    }
}
