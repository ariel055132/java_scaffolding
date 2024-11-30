package com.test.common.bean;


import java.io.Serializable;

public class ServiceRq<T> implements Serializable {
    private static final long serialVersionUID = 6648746575594606251L;

    public T content;

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    // Constructor
    public ServiceRq() {
    }
}
