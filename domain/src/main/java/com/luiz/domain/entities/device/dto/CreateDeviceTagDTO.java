package com.luiz.domain.entities.device.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDeviceTagDTO {

    @NotBlank(message = "device.tag.name.notnull.validation")
    @Size(message = "device.tag.name.length", max = 64)
    private String name;

    public CreateDeviceTagDTO() {
    }

    public CreateDeviceTagDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
