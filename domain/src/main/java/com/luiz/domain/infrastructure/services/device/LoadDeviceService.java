package com.luiz.domain.infrastructure.services.device;

import com.luiz.domain.entities.device.Device;

public interface LoadDeviceService {
    Device call(Long deviceId);
}
