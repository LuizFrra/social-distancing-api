package com.luiz.domain.entities.device;

import javax.persistence.*;

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

    public Device() {
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
}