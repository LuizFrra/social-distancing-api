package com.luiz.infra.services.device;

import com.luiz.domain.infrastructure.services.device.DeleteDeviceEnvService;
import com.luiz.infra.repositories.DeviceEnvRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteDeviceEnvServiceImpl implements DeleteDeviceEnvService {
    private final DeviceEnvRepository deviceEnvRepository;

    public DeleteDeviceEnvServiceImpl(DeviceEnvRepository deviceEnvRepository) {
        this.deviceEnvRepository = deviceEnvRepository;
    }

    @Override
    public void call(Long deviceId, String envName) {
        deviceEnvRepository.deleteInBulkByNameAndDeviceId(envName, deviceId);
    }
}
