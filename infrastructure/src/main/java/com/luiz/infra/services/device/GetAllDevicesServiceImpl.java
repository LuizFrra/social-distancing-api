package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.infrastructure.services.device.GetAllDevicesService;
import com.luiz.infra.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAllDevicesServiceImpl implements GetAllDevicesService {

    private final DeviceRepository deviceRepository;

    public GetAllDevicesServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Iterable<Device> call() {
        return deviceRepository.findAll();
    }
}
