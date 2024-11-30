package com.test.common.bean;

import org.springframework.stereotype.Component;

@Component
public class ServiceRsBuilder {
    public static <T> ServiceRs<T> success(T content) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setContent(content);
        return serviceRs;
    }

    public static <T> ServiceRs<T> error(String errorCode, String errorMessage) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        ServiceInfo serviceInfo = new ServiceInfo();
        //serviceInfo.setErrorCode(errorCode);
        //serviceInfo.setErrorMessage(errorMessage);
        serviceRs.setServiceInfo(serviceInfo);
        return serviceRs;
    }
}
