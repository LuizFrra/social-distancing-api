package com.luiz.domain.entities.device.mapper;

import com.luiz.domain.entities.device.dto.CreateDeviceLogDTO;
import com.luiz.domain.entities.device.dto.DeviceLogDTO;
import com.luiz.domain.entities.device.model.DeviceLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface DeviceLogMapper {
    DeviceLogMapper INSTANCE = Mappers.getMapper(DeviceLogMapper.class);

    DeviceLog fromCreateDeviceLogDTOToDeviceLog(CreateDeviceLogDTO createDeviceLogDTO);

    Collection<DeviceLogDTO> fromDeviceLogToDeviceLogDTO(Collection<DeviceLog> deviceLog);
}
