package com.luiz.domain.entities.device;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Override
    public boolean changeDeviceStatus(Device device, DeviceStatus status) {
        DeviceStatus currStatus = device.getStatus();

        if (currStatus.equals(DeviceStatus.BLOCKED)) {
            return false;
        } else if(currStatus.equals(DeviceStatus.ONLINE) && status.equals(DeviceStatus.OFFLINE)) {
            device.setStatus(status);
            return true;
        } else if(currStatus.equals(DeviceStatus.OFFLINE) && status.equals(DeviceStatus.ONLINE)) {
            device.setStatus(status);
            return true;
        }

        return false;
    }

    @Override
    public boolean createDeviceKey(Device device) {
        if(device.getKey() == null || device.getKey().isEmpty() || device.getKey().isBlank()) {
            device.setKey(UUID.randomUUID().toString().replace("-", ""));
            return true;
        }
        return false;
    }
}
