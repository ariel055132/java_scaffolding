package com.test.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmptyRs implements Serializable {
    private static final long serialVersionUID = 6648746575594606251L;

    public EmptyRs() {

    }
}
