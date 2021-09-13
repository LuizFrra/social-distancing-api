package com.luiz.domain.entities.device.model;

public enum DeviceStatus {
    BLOCKED("BLOCKED"), OFFLINE("OFFLINE"), ONLINE("ONLINE");

    private String status;

    DeviceStatus(String status) {
        this.status = status;
    }
}
