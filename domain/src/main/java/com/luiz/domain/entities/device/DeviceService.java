package com.luiz.domain.entities.device;

import com.luiz.domain.entities.device.model.Device;
import com.luiz.domain.entities.device.model.DeviceEnv;
import com.luiz.domain.entities.device.model.DeviceStatus;
import com.luiz.domain.entities.device.model.DeviceTag;

public interface DeviceService {

    boolean changeDeviceStatus(Device device, DeviceStatus status);

    boolean setupNewDevice(Device device);

    boolean addEnvironmentVariable(Device device, DeviceEnv deviceEnv);

    boolean addTag(Device device, DeviceTag deviceTag);
}
