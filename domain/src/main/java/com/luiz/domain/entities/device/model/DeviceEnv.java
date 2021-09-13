package com.luiz.domain.entities.device.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_environment_variable")
public class DeviceEnv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The variable name identifier
     */
    @Column(name = "name", length = 64)
    private String name;

    /**
     * The variable value
     */
    @Column(name = "value", length = 256)
    private String value;

    /**
     * The device who owner the variable
     */
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public DeviceEnv() {
    }

    public DeviceEnv(Long id, String name, String value, Device device) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
