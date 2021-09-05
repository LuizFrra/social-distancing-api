package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceStatus;
import com.luiz.domain.exceptions.DataAlreadyExistException;
import com.luiz.domain.exceptions.FieldRequiredException;
import com.luiz.domain.infrastructure.services.device.SaveDeviceService;
import com.luiz.infra.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaveDeviceServiceImpl implements SaveDeviceService {

    private final DeviceRepository deviceRepository;

    public SaveDeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> call(Device device) {

        if (device.getKey() == null || device.getKey().isBlank() || device.getKey().isEmpty())
            throw new FieldRequiredException("device.identifier.length");

        device.setStatus(DeviceStatus.OFFLINE);

        Optional<Device> deviceFromDb = deviceRepository.findByIdentifier(device.getIdentifier());

        if(deviceFromDb.isPresent())
            throw new DataAlreadyExistException("device.identifier.ex");

        return Optional.of(deviceRepository.save(device));
    }
}
