package com.codecool.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {

    private final RestInterceptor restInterceptor;
    private final EmailInterceptor emailInterceptor;

    @Autowired
    public InterceptorAppConfig(RestInterceptor restInterceptor, EmailInterceptor emailInterceptor) {
        this.restInterceptor = restInterceptor;
        this.emailInterceptor = emailInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restInterceptor);
        registry.addInterceptor(emailInterceptor);
    }
}
