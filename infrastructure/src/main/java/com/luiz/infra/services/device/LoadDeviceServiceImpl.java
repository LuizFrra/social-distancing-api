package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.exceptions.DataNotFoundException;
import com.luiz.domain.exceptions.FieldRequiredException;
import com.luiz.domain.infrastructure.services.device.LoadDeviceService;
import com.luiz.infra.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class LoadDeviceServiceImpl implements LoadDeviceService {
    private final DeviceRepository deviceRepository;

    public LoadDeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device call(Long deviceId) {
        if(deviceId == null)
            throw new FieldRequiredException("field deviceId is required");

        return deviceRepository.findById(deviceId).orElseThrow(() ->
                new DataNotFoundException(String.format("not found any device with id %d", deviceId))
        );
    }
}
