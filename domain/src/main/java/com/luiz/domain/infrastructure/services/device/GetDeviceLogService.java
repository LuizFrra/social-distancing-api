package com.luiz.domain.infrastructure.services.device;

import com.luiz.domain.entities.device.model.DeviceLog;

import java.util.Collection;

public interface GetDeviceLogService {
    Collection<DeviceLog> call(Long deviceId);
}
