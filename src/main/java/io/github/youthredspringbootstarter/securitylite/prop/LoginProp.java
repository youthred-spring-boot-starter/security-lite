package io.github.youthredspringbootstarter.securitylite.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(prefix = "security.login")
public class LoginProp {

    /**
     * 是否启用默认登录接口 默认启用
     */
    private boolean enable = true;

    public boolean isEnable() {
        return enable;
    }

    public LoginProp setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }
}
