package com.luiz.domain.entities.device.dto;

import com.luiz.domain.entities.device.DeviceStatus;

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

    private List<DeviceEnvDTO> environmentsVariables;

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

    public List<DeviceEnvDTO> getEnvironmentsVariables() {
        return environmentsVariables;
    }

    public void setEnvironmentsVariables(List<DeviceEnvDTO> environmentsVariables) {
        this.environmentsVariables = environmentsVariables;
    }
}
