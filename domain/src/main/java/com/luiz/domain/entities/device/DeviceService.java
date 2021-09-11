package com.luiz.domain.entities.device;

public interface DeviceService {

    boolean changeDeviceStatus(Device device, DeviceStatus status);

    boolean setupNewDevice(Device device);

    boolean addEnvironmentVariable(Device device, DeviceEnv deviceEnv);
}
