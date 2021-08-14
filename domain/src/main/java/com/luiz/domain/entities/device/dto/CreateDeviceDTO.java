package com.luiz.domain.entities.device.dto;

import javax.validation.constraints.NotNull;

public class CreateDeviceDTO {

    @NotNull
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
