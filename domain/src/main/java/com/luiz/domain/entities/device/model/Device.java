package com.luiz.domain.entities.device.model;

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
import java.util.ArrayList;
import java.util.Collection;
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
    private Collection<DeviceEnv> environmentVariables = new ArrayList<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Collection<DeviceTag> tags = new ArrayList<>();

    public Device() {
    }

    public Device(
            Long id,
            String identifier,
            DeviceStatus status,
            String key,
            List<DeviceEnv> environmentVariables,
            List<DeviceTag> tags
    ) {
        this.id = id;
        this.identifier = identifier;
        this.status = status;
        this.key = key;
        this.environmentVariables = environmentVariables;
        this.tags = tags;
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

    public Collection<DeviceEnv> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(Collection<DeviceEnv> environmentsVariables) {
        this.environmentVariables = environmentsVariables;
    }

    public Collection<DeviceTag> getTags() {
        return tags;
    }

    public void setTags(Collection<DeviceTag> tags) {
        this.tags = tags;
    }
}