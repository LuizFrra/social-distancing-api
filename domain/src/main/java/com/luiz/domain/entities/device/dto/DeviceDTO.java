package com.luiz.domain.entities.device.dto;

import com.luiz.domain.entities.device.model.DeviceStatus;

import java.util.List;

public class DeviceDTO {

    private Long id;

    /**
     * A unique device identifier like a MAC Address
     */
    private String identifier;

    /**
     * A data to identifier the current status of device
     */
    private DeviceStatus status;

    private List<DeviceEnvDTO> environmentVariables;

    private List<DeviceTagDTO> tags;

    public DeviceDTO() {
    }

    public DeviceDTO(Long id, String identifier, DeviceStatus status) {
        this.id = id;
        this.identifier = identifier;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status =  status;
    }

    public List<DeviceEnvDTO> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(List<DeviceEnvDTO> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public List<DeviceTagDTO> getTags() {
        return tags;
    }

    public void setTags(List<DeviceTagDTO> tags) {
        this.tags = tags;
    }
}
