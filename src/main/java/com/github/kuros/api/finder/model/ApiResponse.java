package com.github.kuros.api.finder.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiResponse {

    private String description;
    private Set<String> requestType;
    private Set<String> urls;
    private List<Param> pathVariables;
    private List<Param> requestParam;
    private Map<String, ?> requestBody;
    private boolean array;

    public ApiResponse() {
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

    public Set<String> getUrls() {
        return urls;
    }

    public Map<String, ?> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(final Map<String, ?> requestBody) {
        this.requestBody = requestBody;
    }

    public void setUrls(final Set<String> urls) {
        this.urls = urls;
    }

    public boolean isArray() {
        return array;
    }

    public void setArray(final boolean array) {
        this.array = array;
    }
}
