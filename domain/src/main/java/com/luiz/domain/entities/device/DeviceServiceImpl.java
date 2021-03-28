package com.luiz.domain.entities.device;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Override
    public boolean changeDeviceStatus(Device device, DeviceStatus status) {
        DeviceStatus currStatus = device.getStatus();

        if (currStatus.equals(DeviceStatus.BLOCKED) || device.getStatus().equals(status)) {
            return false;
        }

        device.setStatus(status);

        return true;
    }

    @Override
    public boolean createDeviceKey(Device device) {
        if (device.getKey() == null || device.getKey().isEmpty() || device.getKey().isBlank()) {
            device.setKey(UUID.randomUUID().toString().replace("-", ""));
            return true;
        }
        return false;
    }
}
