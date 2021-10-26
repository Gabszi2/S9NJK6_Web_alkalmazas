package hu.me.iit.webapp.nemtudom;

import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {
    private final Dependency dependency;
    private final String value;

    public ServiceImpl(Dependency dependency) {
        this.value=Double.toString(Math.random());
        this.dependency = dependency;
    }
    @Override
    public String getValue() {
        return value;
    }
}
