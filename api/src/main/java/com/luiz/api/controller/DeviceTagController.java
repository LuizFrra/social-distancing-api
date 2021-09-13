package com.luiz.api.controller;

import com.luiz.api.service.DeviceServiceApplication;
import com.luiz.domain.entities.device.dto.CreateDeviceTagDTO;
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
@RequestMapping("/api/v1/device/{deviceId}/tag")
public class DeviceTagController {

    private final DeviceServiceApplication deviceServiceApplication;

    public DeviceTagController(DeviceServiceApplication deviceServiceApplication) {
        this.deviceServiceApplication = deviceServiceApplication;
    }

    @DeleteMapping("/{tagName}")
    public ResponseEntity<DeviceDTO> deleteDeviceTag(
            @PathVariable String tagName,
            @PathVariable Long deviceId
    ) {
        deviceServiceApplication.deleteDeviceTag(deviceId, tagName);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> createDeviceTag(
            @Valid @RequestBody CreateDeviceTagDTO createDeviceTagDTO,
            @PathVariable Long deviceId
    ) {
        return ResponseEntity.ok(deviceServiceApplication.addTag(deviceId, createDeviceTagDTO));
    }
}
