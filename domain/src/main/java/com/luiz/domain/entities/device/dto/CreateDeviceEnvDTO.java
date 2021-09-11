package com.luiz.domain.entities.device.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDeviceEnvDTO {

    @NotBlank(message = "device.env.name.notnull.validation")
    @Size(message = "device.env.name.length", max = 64)
    private String name;

    @NotBlank(message = "device.env.value.notnull.validation")
    @Size(message = "device.env.value.length", max = 256)
    private String value;

    public CreateDeviceEnvDTO() {
    }

    public CreateDeviceEnvDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
