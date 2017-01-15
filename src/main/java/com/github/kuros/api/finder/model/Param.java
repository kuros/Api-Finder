package com.github.kuros.api.finder.model;

import com.github.kuros.api.finder.config.BasicType;

public class Param {
    private String key;
    private BasicType type;

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public BasicType getType() {
        return type;
    }

    public void setType(final BasicType type) {
        this.type = type;
    }
}
