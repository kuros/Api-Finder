package com.github.kuros.api.finder.mapping;

import com.github.kuros.api.finder.model.ApiResponse;
import com.github.kuros.api.finder.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class MappingInfoImpl implements MappingInfo {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private List<ApiResponse> apiResponses = new ArrayList<ApiResponse>();

    public void listAll() {
        final Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo requestMappingInfo : handlerMethods.keySet()) {
            ApiResponse apiResponse = new ApiResponse();
            System.out.println(requestMappingInfo);
            final HandlerMethod handlerMethod = handlerMethods.get(requestMappingInfo);

            apiResponse.setDescription(getDescription(handlerMethod.getMethod()));
            apiResponse.setUrl(getUrls(requestMappingInfo));
            apiResponse.setRequestType(getRequestTypes(requestMappingInfo));
//            apiResponse.setRequestType();

            final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        }
    }

    private Set<String> getRequestTypes(final RequestMappingInfo requestMappingInfo) {
        final Set<RequestMethod> methods = requestMappingInfo.getMethodsCondition().getMethods();
        Set<String> requestType = new HashSet<String>();
        for (RequestMethod method : methods) {
            requestType.add(method.name());
        }
        return requestType;
    }

    private Set<String> getUrls(final RequestMappingInfo requestMappingInfo) {
        return requestMappingInfo.getPatternsCondition().getPatterns();
    }

    private String getDescription(final Method method) {
        return Util.convertCamelCase(method.getName());
    }
}
