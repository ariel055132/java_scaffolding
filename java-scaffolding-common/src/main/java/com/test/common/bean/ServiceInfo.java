package com.test.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ServiceInfo implements Serializable {
    private static final long serialVersionUID = -3872343762949842735L;

    // 時間戳記
    private LocalDateTime timeStamp = LocalDateTime.now();

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
