package com.luiz.domain.entities.device.dto;

import java.util.Map;

public class DeviceLogDTO {
    private String id;

    private Long deviceId;

    private Map<String, String> payload;

    public DeviceLogDTO() {
    }

    public DeviceLogDTO(String id, Long deviceId, Map<String, String> payload) {
        this.id = id;
        this.deviceId = deviceId;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }
}
