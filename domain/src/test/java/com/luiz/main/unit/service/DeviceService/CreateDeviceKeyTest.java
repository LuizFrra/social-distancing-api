package com.luiz.main.unit.service.DeviceService;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.DeviceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@Import(
        DeviceServiceImpl.class
)
public class CreateDeviceKeyTest {

    @Autowired
    DeviceService deviceService;

    @Test
    public void should_setup_an_key_if_device_havent_one() {
        Device device = new Device();
        Assertions.assertTrue(deviceService.createDeviceKey(device));
        Assertions.assertNotNull(device.getKey());
        Assertions.assertNotEquals("", device.getKey().trim());
    }

    @Test
    public void should_return_false_if_device_already_have_an_key() {
        Device device = new Device();
        String key = UUID.randomUUID().toString().replace("-", "");
        device.setKey(key);
        Assertions.assertFalse(deviceService.createDeviceKey(device));
        Assertions.assertEquals(key, device.getKey());
    }
}
