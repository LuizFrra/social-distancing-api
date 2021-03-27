package com.luiz.domain.entities.device;

import org.springframework.stereotype.Service;

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
}
