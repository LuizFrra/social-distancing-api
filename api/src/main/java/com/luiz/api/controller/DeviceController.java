package com.luiz.api.controller;

import com.luiz.api.service.DeviceServiceApplication;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final DeviceServiceApplication deviceServiceApplication;

    public DeviceController(DeviceServiceApplication deviceServiceApplication) {
        this.deviceServiceApplication = deviceServiceApplication;
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> createDevice(@Valid @RequestBody CreateDeviceDTO createDeviceDTO) {
        return ResponseEntity.ok(deviceServiceApplication.createDevice(createDeviceDTO));
    }
}
