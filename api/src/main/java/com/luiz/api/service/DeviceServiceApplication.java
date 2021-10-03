package com.luiz.api.service;

import com.luiz.domain.entities.device.dto.CreateDeviceLogDTO;
import com.luiz.domain.entities.device.dto.DeviceLogDTO;
import com.luiz.domain.entities.device.mapper.DeviceLogMapper;
import com.luiz.domain.entities.device.model.Device;
import com.luiz.domain.entities.device.model.DeviceEnv;
import com.luiz.domain.entities.device.mapper.DeviceEnvMapper;
import com.luiz.domain.entities.device.mapper.DeviceMapper;
import com.luiz.domain.entities.device.DeviceService;
import com.luiz.domain.entities.device.model.DeviceLog;
import com.luiz.domain.entities.device.model.DeviceTag;
import com.luiz.domain.entities.device.mapper.DeviceTagMapper;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.CreateDeviceEnvDTO;
import com.luiz.domain.entities.device.dto.CreateDeviceTagDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import com.luiz.domain.exceptions.DataNotFoundException;
import com.luiz.domain.infrastructure.services.device.DeleteDeviceEnvService;
import com.luiz.domain.infrastructure.services.device.DeleteDeviceTagService;
import com.luiz.domain.infrastructure.services.device.ExistDeviceService;
import com.luiz.domain.infrastructure.services.device.GetAllDevicesService;
import com.luiz.domain.infrastructure.services.device.InsertDeviceLogService;
import com.luiz.domain.infrastructure.services.device.LoadDeviceService;
import com.luiz.domain.infrastructure.services.device.SaveDeviceService;
import com.luiz.domain.infrastructure.services.device.UpdateDeviceService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceServiceApplication {

    private final DeviceService deviceService;

    private final SaveDeviceService saveDeviceService;

    private final GetAllDevicesService getAllDevicesService;

    private final LoadDeviceService loadDeviceService;

    private final UpdateDeviceService updateDeviceService;

    private final DeleteDeviceEnvService deleteDeviceEnvService;

    private final DeleteDeviceTagService deleteDeviceTagService;

    private final InsertDeviceLogService insertDeviceLogService;

    private final ExistDeviceService existDeviceService;

    public DeviceServiceApplication(
            DeviceService deviceService,
            SaveDeviceService saveDeviceService,
            GetAllDevicesService getAllDevicesService,
            LoadDeviceService loadDeviceService,
            UpdateDeviceService updateDeviceService,
            DeleteDeviceEnvService deleteDeviceEnvService,
            DeleteDeviceTagService deleteDeviceTagService,
            InsertDeviceLogService insertDeviceLogService,
            ExistDeviceService existDeviceService) {
        this.deviceService = deviceService;
        this.saveDeviceService = saveDeviceService;
        this.getAllDevicesService = getAllDevicesService;
        this.loadDeviceService = loadDeviceService;
        this.updateDeviceService = updateDeviceService;
        this.deleteDeviceEnvService = deleteDeviceEnvService;
        this.deleteDeviceTagService = deleteDeviceTagService;
        this.insertDeviceLogService = insertDeviceLogService;
        this.existDeviceService = existDeviceService;
    }

    public DeviceDTO createDevice(CreateDeviceDTO createDeviceDTO) {
        Device device = DeviceMapper.INSTANCE.createDeviceDTOToDevice(createDeviceDTO);
        deviceService.setupNewDevice(device);
        Optional<Device> createdDevice = saveDeviceService.call(device);
        return createdDevice.map(DeviceMapper.INSTANCE::deviceToDeviceDTO).orElse(null);
    }

    public List<DeviceDTO> getAllDevices() {
        return StreamSupport
                .stream(getAllDevicesService.call().spliterator(), true)
                .map(DeviceMapper.INSTANCE::deviceToDeviceDTO)
                .collect(Collectors.toList());
    }

    public DeviceDTO addEnvironmentVariable(Long deviceId, CreateDeviceEnvDTO environmentDTO) {
        Device device = loadDeviceService.call(deviceId);
        DeviceEnv deviceEnv = DeviceEnvMapper.INSTANCE.createDeviceEnvDTOToDeviceEnv(environmentDTO);
        deviceService.addEnvironmentVariable(device, deviceEnv);
        Device updatedDevice = updateDeviceService.call(device);
        return DeviceMapper.INSTANCE.deviceToDeviceDTO(updatedDevice);
    }

    public DeviceDTO addTag(Long deviceId, CreateDeviceTagDTO tagDTO) {
        Device device = loadDeviceService.call(deviceId);
        DeviceTag deviceTag = DeviceTagMapper.INSTANCE.createDeviceTagDTOToDeviceTag(tagDTO);
        deviceService.addTag(device, deviceTag);
        Device updatedDevice = updateDeviceService.call(device);
        return DeviceMapper.INSTANCE.deviceToDeviceDTO(updatedDevice);
    }

    public void deleteDeviceEnv(Long deviceId, String envName) {
        deleteDeviceEnvService.call(deviceId, envName);
    }

    public void deleteDeviceTag(Long deviceId, String tagName) {
        deleteDeviceTagService.call(deviceId, tagName);
    }

    public Collection<DeviceLogDTO> addLog(Long deviceId, CreateDeviceLogDTO createDeviceLogDTO) {
        boolean deviceExist = existDeviceService.call(deviceId);
        if(!deviceExist) throw new DataNotFoundException("device does not exist");
        Device device = new Device(deviceId, null, null, null);
        DeviceLog deviceLog = DeviceLogMapper.INSTANCE.fromCreateDeviceLogDTOToDeviceLog(createDeviceLogDTO);
        deviceService.addLog(device, deviceLog);
        device = insertDeviceLogService.call(device);
        return DeviceLogMapper.INSTANCE.fromDeviceLogToDeviceLogDTO(device.getLogs());
    }
}
