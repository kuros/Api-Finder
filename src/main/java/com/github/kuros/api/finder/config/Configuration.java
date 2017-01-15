package com.github.kuros.api.finder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public ParameterNameDiscoverer getParameterNameDiscoverer() {
        return new LocalVariableTableParameterNameDiscoverer();
    }
}
