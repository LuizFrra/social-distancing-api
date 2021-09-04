package com.luiz.domain.infrastructure.services.device;

import com.luiz.domain.entities.device.Device;

public interface GetAllDevicesService {
    Iterable<Device> call();
}
