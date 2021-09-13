package com.luiz.domain.infrastructure.services.device;

import com.luiz.domain.entities.device.model.Device;

import java.util.Optional;

public interface SaveDeviceService {
    Optional<Device> call(Device device);
}
