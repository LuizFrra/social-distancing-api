package com.luiz.domain.entities.device.dto;

import java.util.Map;

public class CreateDeviceLogDTO {
    private Map<String, String> payload;

    public CreateDeviceLogDTO(Map<String, String> payload) {
        this.payload = payload;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }
}
