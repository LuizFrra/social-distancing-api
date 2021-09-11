package com.luiz.domain.entities.device;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A unique device identifier like a MAC Address
     */
    @Column(unique = true, length = 20, updatable = false, nullable = false)
    private String identifier;

    /**
     * A data to identifier the current status of device
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    /**
     * This data will be use to encrypt device communication
     */
    @Column(length = 20)
    private String key;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<DeviceEnv> environmentVariables;

    public Device() {
    }

    public Device(Long id, String identifier, DeviceStatus status, String key, List<DeviceEnv> environmentVariables) {
        this.id = id;
        this.identifier = identifier;
        this.status = status;
        this.key = key;
        this.environmentVariables = environmentVariables;
    }

    public Device(Long id, String identifier, DeviceStatus status, String key) {
        this.id = id;
        this.identifier = identifier;
        this.status = status;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<DeviceEnv> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(List<DeviceEnv> environmentsVariables) {
        this.environmentVariables = environmentsVariables;
    }
}