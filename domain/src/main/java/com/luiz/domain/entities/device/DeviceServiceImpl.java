package com.luiz.domain.entities.device;

import com.luiz.domain.exceptions.DataAlreadyExistException;
import com.luiz.domain.exceptions.FieldRequiredException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Predicate;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Override
    public boolean changeDeviceStatus(Device device, DeviceStatus status) {
        DeviceStatus currStatus = device.getStatus();

        if (currStatus != null && (currStatus.equals(DeviceStatus.BLOCKED) || device.getStatus().equals(status))) {
            return false;
        }

        device.setStatus(status);

        return true;
    }

    @Override
    public boolean setupNewDevice(Device device) {
        String currentDeviceKey = device.getKey();
        device.setStatus(DeviceStatus.OFFLINE);
        if (currentDeviceKey == null || currentDeviceKey.trim().isEmpty()) {
            device.setKey(UUID.randomUUID().toString().replace("-", ""));
            return true;
        }
        return false;
    }

    @Override
    public boolean addEnvironmentVariable(Device device, DeviceEnv deviceEnv) {
        Predicate<String> isEmptyOrNull = str -> str == null || str.isEmpty() || str.isBlank();

        if(isEmptyOrNull.test(deviceEnv.getName()))
            throw new FieldRequiredException("device.env.name.notnull.validation");

        if(isEmptyOrNull.test(deviceEnv.getValue()))
            throw new FieldRequiredException("device.env.value.notnull.validation");

        device.getEnvironmentVariables().forEach(env -> {
            if(env.getName().equals(deviceEnv.getName()))
                throw new DataAlreadyExistException("device.env.ex");
        });

        deviceEnv.setDevice(device);
        device.getEnvironmentVariables().add(deviceEnv);

        return true;
    }
}
