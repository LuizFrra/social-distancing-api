package com.luiz.infra.integration.service;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.DeviceServiceImpl;
import com.luiz.domain.entities.device.DeviceStatus;
import com.luiz.domain.exceptions.DataAlreadyExistException;
import com.luiz.domain.exceptions.FieldRequiredException;
import com.luiz.domain.infrastructure.services.device.SaveDeviceService;
import com.luiz.infra.integration.common.DBContainerIntegrationTest;
import com.luiz.infra.services.device.SaveDeviceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;
import java.util.UUID;

@Import({
        SaveDeviceServiceImpl.class,
        DeviceServiceImpl.class
})
class SaveDeviceServiceTest extends DBContainerIntegrationTest {

    @Autowired
    private SaveDeviceService saveDeviceService;

    @Autowired
    private DeviceService deviceService;

    @Test
    void should_save_device() {
        Device device = new Device();
        device.setIdentifier(generateIdentifier());
        deviceService.setupNewDevice(device);
        Optional<Device> savedDevice = saveDeviceService.call(device);
        Assertions.assertTrue(savedDevice.isPresent());
        Assertions.assertNotNull(savedDevice.get().getId());
    }

    @Test
    void should_throw_exception_if_already_exist_device_with_same_identifier() {
        Device device = new Device();
        device.setIdentifier(generateIdentifier());
        deviceService.setupNewDevice(device);
        saveDeviceService.call(device);
        Assertions.assertThrows(DataAlreadyExistException.class, () -> {
           saveDeviceService.call(device);
        });
    }

    @Test
    void should_save_device_with_offline_status() {
        Device device = new Device();
        device.setStatus(DeviceStatus.ONLINE);
        device.setIdentifier(generateIdentifier());
        deviceService.setupNewDevice(device);
        Optional<Device> savedDevice = saveDeviceService.call(device);
        Assertions.assertTrue(savedDevice.isPresent());
        Assertions.assertEquals(DeviceStatus.OFFLINE, savedDevice.get().getStatus());
    }

    @Test
    void should_not_save_device_with_identifier_greater_than_20() {
        Device device = new Device();
        device.setIdentifier(UUID.randomUUID().toString());
        deviceService.setupNewDevice(device);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            saveDeviceService.call(device);
        });
    }

    @Test
    void should_not_save_device_when_key_is_empty() {
        Assertions.assertThrows(FieldRequiredException.class, () -> {
            deviceTestKey("");
        });
    }

    @Test
    void should_not_save_device_when_key_is_null() {
        Assertions.assertThrows(FieldRequiredException.class, () -> {
            deviceTestKey(null);
        });
    }

    @Test
    void should_not_save_device_when_key_is_blank() {
        Assertions.assertThrows(FieldRequiredException.class, () -> {
            deviceTestKey("    ");
        });
    }

    void deviceTestKey(String keyValue) {
        Device device = new Device();
        device.setKey(keyValue);
        saveDeviceService.call(device);
    }

    private String generateIdentifier() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
