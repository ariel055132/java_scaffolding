package com.test.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ServiceInfo implements Serializable {
    private static final long serialVersionUID = -3872343762949842735L;

    // 時間戳記
    private LocalDateTime timeStamp = LocalDateTime.now();

    // 誰發起的請求
    private String userId;

    // 是否成功
    private boolean status;

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
