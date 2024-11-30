package com.test.common.bean;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 608410198330865917L;

    private ServiceInfo serviceInfo;

    private T serviceRs;

    public ApiResponse(ServiceInfo serviceInfo, T serviceRs) {
        this.serviceInfo = serviceInfo;
        this.serviceRs = serviceRs;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public T getServiceRs() {
        return serviceRs;
    }

    public void setServiceRs(T serviceRs) {
        this.serviceRs = serviceRs;
    }
}
