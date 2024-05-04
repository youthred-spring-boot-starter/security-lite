package io.github.youthredspringbootstarter.securitylite.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Validated
@ConfigurationProperties(prefix = "security")
public class SecurityProp {

    private boolean enable;

    private Map<String, String[]> staticResource;

    public boolean isEnable() {
        return enable;
    }

    public SecurityProp setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public Map<String, String[]> getStaticResource() {
        return staticResource;
    }

    public SecurityProp setStaticResource(Map<String, String[]> staticResource) {
        this.staticResource = staticResource;
        return this;
    }
}
