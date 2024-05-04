package io.github.youthredspringbootstarter.securitylite.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Validated
@ConfigurationProperties(prefix = "security")
public class SecurityProp {

    private boolean enable;

    private Map<String, String[]> staticResources;

    public boolean isEnable() {
        return enable;
    }

    public SecurityProp setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public Map<String, String[]> getStaticResources() {
        return staticResources;
    }

    public SecurityProp setStaticResources(Map<String, String[]> staticResources) {
        this.staticResources = staticResources;
        return this;
    }
}
