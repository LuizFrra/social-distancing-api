package com.luiz.infra.services.device;

import com.luiz.domain.infrastructure.services.device.ExistDeviceService;
import com.luiz.infra.repositories.DeviceRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExistDeviceServiceImpl implements ExistDeviceService {

    private final DeviceRepository deviceRepository;

    public ExistDeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    @Cacheable("device_exist")
    public boolean call(Long deviceId) {
        return deviceRepository.existsById(deviceId);
    }
}
