package com.github.kuros.api.finder.mapping;

import com.github.kuros.api.finder.config.BasicType;
import com.github.kuros.api.finder.model.ApiResponse;
import com.github.kuros.api.finder.model.Param;
import com.github.kuros.api.finder.utils.Util;
import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONFactory;
import com.oracle.javafx.jmx.json.JSONReader;
import com.oracle.javafx.jmx.json.impl.JSONMessages;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class MappingInfoImpl implements MappingInfo {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    private ParameterNameDiscoverer parameterNameDiscoverer;

    private List<ApiResponse> apiResponses = new ArrayList<ApiResponse>();

    public MappingInfoImpl() {
        parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
    }

    public void listAll() {
        final Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo requestMappingInfo : handlerMethods.keySet()) {
            ApiResponse apiResponse = new ApiResponse();
            System.out.println(requestMappingInfo);
            final HandlerMethod handlerMethod = handlerMethods.get(requestMappingInfo);

            apiResponse.setDescription(getDescription(handlerMethod));
            apiResponse.setUrls(getUrls(requestMappingInfo));
            apiResponse.setRequestType(getRequestTypes(requestMappingInfo));
            apiResponse.setRequestParam(getParams(handlerMethod));
            apiResponse.setPathVariables(getPathVariables(handlerMethod));
            apiResponse.setRequestBody(getRequestBody(handlerMethod));

            System.out.println();


            final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        }
    }

    private Map<String, Object> getRequestBody(final HandlerMethod handlerMethod) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            final Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
            for (Annotation parameterAnnotation : parameterAnnotations) {
                if (parameterAnnotation instanceof RequestBody) {
                    final Class<?> parameterType = methodParameter.getParameterType();

                    final BasicType basicType = BasicType.getType(parameterType);
                    if (basicType != null) {
                        methodParameter.initParameterNameDiscovery(parameterNameDiscoverer);
                        requestBody.put(methodParameter.getParameterName(), basicType.name());
                    } else {
                        requestBody = ComplexMapping.getAttributeWithType(parameterType);
                    }
                }
            }
        }

        return requestBody;
    }


    private List<Param> getPathVariables(final HandlerMethod handlerMethod) {
        final List<Param> params = new ArrayList<Param>();

        final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            final Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
            for (Annotation annotation : parameterAnnotations) {
                if (annotation instanceof PathVariable) {
                    final PathVariable pathVariable = (PathVariable) annotation;
                    if (isEmpty(pathVariable.value())) {
                        methodParameter.initParameterNameDiscovery(parameterNameDiscoverer);
                        final Param param = new Param();
                        param.setKey(methodParameter.getParameterName());
                        param.setType(BasicType.getType(methodParameter.getParameterType()));
                        params.add(param);
                    } else {
                        final Param param = new Param();
                        param.setKey(pathVariable.value());
                        param.setType(BasicType.getType(methodParameter.getParameterType()));
                        params.add(param);
                    }
                }
            }
        }
        return params;
    }

    private List<Param> getParams(final HandlerMethod handlerMethod) {
        final List<Param> params = new ArrayList<Param>();

        final MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            final Annotation[] parameterAnnotations = methodParameter.getParameterAnnotations();
            for (Annotation annotation : parameterAnnotations) {
                if (annotation instanceof RequestParam) {
                    final RequestParam requestParam = (RequestParam) annotation;
                    if (isEmpty(requestParam.value())) {
                        methodParameter.initParameterNameDiscovery(parameterNameDiscoverer);
                        final Param param = new Param();
                        param.setKey(methodParameter.getParameterName());
                        param.setType(BasicType.getType(methodParameter.getParameterType()));
                        params.add(param);
                    } else {
                        final Param param = new Param();
                        param.setKey(requestParam.value());
                        param.setType(BasicType.getType(methodParameter.getParameterType()));
                        params.add(param);
                    }
                }
            }
        }

        return params;
    }

    private boolean isEmpty(final String value) {
        return value.equals("");
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

    private String getDescription(final HandlerMethod handlerMethod) {
        return Util.convertCamelCase(handlerMethod.getMethod().getName());
    }
}
