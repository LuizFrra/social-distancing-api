package com.luiz.domain.entities.device.dto;

public class DeviceTagDTO {

    private String name;

    public DeviceTagDTO() {
    }

    public DeviceTagDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
