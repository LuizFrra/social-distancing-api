package com.luiz.domain.entities.device;

public interface DeviceService {

    boolean changeDeviceStatus(Device device, DeviceStatus status);

    boolean createDeviceKey(Device device);

}
