package com.test.common.bean;

import java.io.Serializable;

public class ServiceRs<T> implements Serializable {
    private static final long serialVersionUID = 6648746575594606251L;

    private T content;

    public T getContent() {
        return this.content;
    }

    public T setContent(T content) {
        return this.content = content;
    }

    // Constructor
    public ServiceRs() {
    }
}
