package com.luiz.api.controller;

import com.luiz.api.service.DeviceServiceApplication;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.CreateDeviceEnvDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceServiceApplication deviceServiceApplication;

    public DeviceController(DeviceServiceApplication deviceServiceApplication) {
        this.deviceServiceApplication = deviceServiceApplication;
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> createDevice(@Valid @RequestBody CreateDeviceDTO createDeviceDTO) {
        return new ResponseEntity<>(deviceServiceApplication.createDevice(createDeviceDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeviceDTO>> getAllDevices() {
        return ResponseEntity.ok(deviceServiceApplication.getAllDevices());
    }

    @PostMapping("/{deviceId}/env")
    public ResponseEntity<DeviceDTO> createDeviceEnvironment(
            @Valid @RequestBody CreateDeviceEnvDTO createDeviceEnvDTO,
            @PathVariable Long deviceId
    ) {
        return ResponseEntity.ok(deviceServiceApplication.addEnvironmentVariable(deviceId, createDeviceEnvDTO));
    }
}
