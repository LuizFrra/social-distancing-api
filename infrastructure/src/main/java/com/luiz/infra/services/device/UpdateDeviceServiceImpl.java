package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.model.Device;
import com.luiz.domain.exceptions.FieldRequiredException;
import com.luiz.domain.infrastructure.services.device.LoadDeviceService;
import com.luiz.domain.infrastructure.services.device.UpdateDeviceService;
import com.luiz.infra.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateDeviceServiceImpl implements UpdateDeviceService {

    private final DeviceRepository deviceRepository;

    private final LoadDeviceService loadDeviceService;

    public UpdateDeviceServiceImpl(DeviceRepository deviceRepository, LoadDeviceService loadDeviceService) {
        this.deviceRepository = deviceRepository;
        this.loadDeviceService = loadDeviceService;
    }

    @Override
    public Device call(Device device) {
        if(device == null)
            throw new FieldRequiredException("field device is required");

        if(device.getId() == null)
            throw new FieldRequiredException("field device id is required");

        Device deviceFromDb = loadDeviceService.call(device.getId());

        deviceFromDb.setEnvironmentVariables(device.getEnvironmentVariables());

        return deviceRepository.save(deviceFromDb);
    }
}
