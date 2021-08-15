package com.luiz.domain.entities.device.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateDeviceDTO {

    @NotBlank(message = "device.identifier.length")
    @NotNull(message = "device.identifier.notnull.validation")
    @Size(message = "device.identifier.length", min = 1, max = 20)
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
