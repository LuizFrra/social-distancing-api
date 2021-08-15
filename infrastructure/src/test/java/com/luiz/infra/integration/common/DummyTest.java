package com.luiz.infra.integration.common;

import com.luiz.domain.entities.device.Device;
import com.luiz.infra.repositories.DeviceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import org.springframework.beans.factory.annotation.Autowired;

class DummyTest extends DBContainerIntegrationTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    void should_save_device() {
        Device device = new Device();
        device.setIdentifier("dsds");
        device.setKey("dsdsd");
        deviceRepository.save(device);
        Assertions.assertNotNull(device.getId());
    }
}
