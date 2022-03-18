package com.company.crm.workbench.config;

import com.company.crm.workbench.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zytwl
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/settings/**")
                .addPathPatterns("/workbench/**")
                .excludePathPatterns("/settings/qx/user/login.do","/settings/qx/user/toLogin.do");
    }
}
