package com.luiz.domain.entities.device.dto;

public class CreateDeviceDTO {

    public String identifier;

    public CreateDeviceDTO() {
    }

    public CreateDeviceDTO(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
