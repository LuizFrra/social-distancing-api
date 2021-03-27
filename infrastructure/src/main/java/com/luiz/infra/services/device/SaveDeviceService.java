package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.Device;

import java.util.Optional;

public interface SaveDeviceService {
    Optional<Device> call(Device device);
}
