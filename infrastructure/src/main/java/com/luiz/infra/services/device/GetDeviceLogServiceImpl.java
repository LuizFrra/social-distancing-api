package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.model.DeviceLog;
import com.luiz.domain.infrastructure.services.device.GetDeviceLogService;
import com.luiz.infra.repositories.DeviceLogRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GetDeviceLogServiceImpl implements GetDeviceLogService {

    private final DeviceLogRepository deviceLogRepository;

    public GetDeviceLogServiceImpl(DeviceLogRepository deviceLogRepository) {
        this.deviceLogRepository = deviceLogRepository;
    }

    @Override
    public Collection<DeviceLog> call(Long deviceId) {
        return deviceLogRepository.findTop10ByDeviceIdOrderByTimestampDesc(deviceId);
    }
}
