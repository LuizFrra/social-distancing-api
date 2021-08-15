package com.luiz.domain.unit.service.DeviceService;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.DeviceServiceImpl;
import com.luiz.domain.entities.device.DeviceStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(
        DeviceServiceImpl.class
)
class ChangeDeviceStatusTest {

    @Autowired
    private DeviceService deviceService;

    @Test
    void should_return_false_when_try_change_status_from_blocked_to_online() {
        Device device = new Device(0L, "123", DeviceStatus.BLOCKED, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.ONLINE);

        Assertions.assertFalse(result);
    }

    @Test
    void should_return_false_when_try_change_status_from_blocked_to_offline() {
        Device device = new Device(0L, "123", DeviceStatus.BLOCKED, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.OFFLINE);

        Assertions.assertFalse(result);
    }

    @Test
    void should_return_true_when_try_change_status_from_online_to_offline() {
        Device device = new Device(0L, "123", DeviceStatus.ONLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.OFFLINE);

        Assertions.assertTrue(result);
    }

    @Test
    void should_return_true_when_try_change_status_from_online_to_blocked() {
        Device device = new Device(0L, "123", DeviceStatus.ONLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.BLOCKED);

        Assertions.assertTrue(result);
    }

    @Test
    void should_return_true_when_try_change_status_from_offline_to_online() {
        Device device = new Device(0L, "123", DeviceStatus.OFFLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.ONLINE);

        Assertions.assertTrue(result);
    }

    @Test
    void should_return_true_when_try_change_status_from_offline_to_blocked() {
        Device device = new Device(0L, "123", DeviceStatus.OFFLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.BLOCKED);

        Assertions.assertTrue(result);
    }

    @Test
    void should_return_false_when_try_change_status_from_offline_to_offline() {
        Device device = new Device(0L, "123", DeviceStatus.OFFLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.OFFLINE);

        Assertions.assertFalse(result);
    }

    @Test
    void should_return_false_when_try_change_status_from_online_to_online() {
        Device device = new Device(0L, "123", DeviceStatus.ONLINE, "123");

        boolean result = deviceService.changeDeviceStatus(device, DeviceStatus.ONLINE);

        Assertions.assertFalse(result);
    }
}
