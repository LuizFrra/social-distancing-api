package com.luiz.api.service;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceMapper;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import com.luiz.domain.infrastructure.services.device.SaveDeviceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceServiceApplication {

    private final DeviceService deviceService;

    private final SaveDeviceService saveDeviceService;

    public DeviceServiceApplication(DeviceService deviceService, SaveDeviceService saveDeviceService) {
        this.deviceService = deviceService;
        this.saveDeviceService = saveDeviceService;
    }

    public DeviceDTO createDevice(CreateDeviceDTO createDeviceDTO) {
        Device device = new Device();
        device.setIdentifier(createDeviceDTO.getIdentifier());
        deviceService.createDeviceKey(device);
        Optional<Device> createdDevice = saveDeviceService.call(device);
        return createdDevice.map(DeviceMapper.INSTANCE::deviceToDeviceDTO).orElse(null);
    }
}
