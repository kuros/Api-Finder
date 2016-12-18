package com.github.kuros.api.finder.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;

public class ApiResponse {

    private String description;
    private Set<String> requestType;
    private Set<String> urls;
    private List<Param> pathVariables;
    private List<Param> requestParam;
    private Object requestBody;
    private boolean inValid;
    private boolean responseArray;

    public ApiResponse() {
        pathVariables = Lists.newArrayList();
        requestParam = Lists.newArrayList();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<String> getRequestType() {
        return requestType;
    }

    public void setRequestType(final Set<String> requestType) {
        this.requestType = requestType;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrl(final Set<String> url) {
        this.urls = urls;
    }

    public List<Param> getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(final List<Param> pathVariables) {
        this.pathVariables = pathVariables;
    }

    public List<Param> getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(final List<Param> requestParam) {
        this.requestParam = requestParam;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(final Object requestBody) {
        this.requestBody = requestBody;
    }

    public boolean isInValid() {
        return inValid;
    }

    public void setInValid(final boolean inValid) {
        this.inValid = inValid;
    }

    public boolean isResponseArray() {
        return responseArray;
    }

    public void setResponseArray(final boolean responseArray) {
        this.responseArray = responseArray;
    }
}
