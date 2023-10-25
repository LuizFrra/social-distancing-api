package com.luiz.api.controller;

import com.luiz.api.service.DeviceServiceApplication;
import com.luiz.domain.entities.device.dto.CreateDeviceEnvDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/device/{deviceId}/env")
public class DeviceEnvController {

    private final DeviceServiceApplication deviceServiceApplication;

    public DeviceEnvController(DeviceServiceApplication deviceServiceApplication) {
        this.deviceServiceApplication = deviceServiceApplication;
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> createDeviceEnvironment(
            @Valid @RequestBody CreateDeviceEnvDTO createDeviceEnvDTO,
            @PathVariable Long deviceId
    ) {
        return ResponseEntity.ok(deviceServiceApplication.addEnvironmentVariable(deviceId, createDeviceEnvDTO));
    }

    @DeleteMapping("/{envName}")
    public ResponseEntity<DeviceDTO> deleteDeviceEnvironment(
            @PathVariable String envName,
            @PathVariable Long deviceId
    ) {
        deviceServiceApplication.deleteDeviceEnv(deviceId, envName);
        return ResponseEntity.ok().build();
    }
}
