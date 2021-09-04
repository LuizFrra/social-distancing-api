package com.luiz.api.service;

import com.luiz.domain.entities.device.Device;
import com.luiz.domain.entities.device.DeviceMapper;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import com.luiz.domain.infrastructure.services.device.GetAllDevicesService;
import com.luiz.domain.infrastructure.services.device.SaveDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceServiceApplication {

    private final DeviceService deviceService;

    private final SaveDeviceService saveDeviceService;

    private final GetAllDevicesService getAllDevicesService;

    public DeviceServiceApplication(
            DeviceService deviceService,
            SaveDeviceService saveDeviceService,
            GetAllDevicesService getAllDevicesService
    ) {
        this.deviceService = deviceService;
        this.saveDeviceService = saveDeviceService;
        this.getAllDevicesService = getAllDevicesService;
    }

    public DeviceDTO createDevice(CreateDeviceDTO createDeviceDTO) {
        Device device = DeviceMapper.INSTANCE.createDeviceDTOToDevice(createDeviceDTO);
        deviceService.createDeviceKey(device);
        Optional<Device> createdDevice = saveDeviceService.call(device);
        return createdDevice.map(DeviceMapper.INSTANCE::deviceToDeviceDTO).orElse(null);
    }

    public List<DeviceDTO> getAllDevices() {
        return StreamSupport
                .stream(getAllDevicesService.call().spliterator(), true)
                .map(DeviceMapper.INSTANCE::deviceToDeviceDTO)
                .collect(Collectors.toList());
    }
}
