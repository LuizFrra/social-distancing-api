package com.luiz.api.controller;

import com.luiz.api.service.DeviceServiceApplication;
import com.luiz.domain.entities.device.dto.CreateDeviceLogDTO;
import com.luiz.domain.entities.device.dto.DeviceLogDTO;
import com.luiz.domain.entities.device.model.DeviceLog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/device/{deviceId}/log")
public class DeviceLogController {

    private final DeviceServiceApplication deviceServiceApplication;

    public DeviceLogController(DeviceServiceApplication deviceServiceApplication) {
        this.deviceServiceApplication = deviceServiceApplication;
    }

    @PostMapping
    public ResponseEntity<Collection<DeviceLogDTO>> addLog(@PathVariable Long deviceId, @RequestBody Map<String, String> log) {
        CreateDeviceLogDTO createDeviceLogDTO = new CreateDeviceLogDTO(log);
        return ResponseEntity.ok(deviceServiceApplication.addLog(deviceId, createDeviceLogDTO));
    }

    @GetMapping
    public ResponseEntity<Collection<DeviceLog>> getLogs(@PathVariable Long deviceId) {
        return ResponseEntity.ok(deviceServiceApplication.getAllDeviceLog(deviceId));
    }
}
