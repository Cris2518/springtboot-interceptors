package com.kumon.curso.springboot.app.interceptor.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor loadingHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(loadingHandlerInterceptor).addPathPatterns("/app/bar",
        // "/app/foo");
        registry.addInterceptor(loadingHandlerInterceptor).excludePathPatterns("/app/bar");
    }
}
