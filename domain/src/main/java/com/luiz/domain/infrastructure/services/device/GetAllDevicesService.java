package com.luiz.domain.infrastructure.services.device;

import com.luiz.domain.entities.device.model.Device;

public interface GetAllDevicesService {
    Iterable<Device> call();
}
