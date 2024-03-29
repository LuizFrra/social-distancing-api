package com.luiz.domain.entities.device.mapper;

import com.luiz.domain.entities.device.dto.CreateDeviceEnvDTO;
import com.luiz.domain.entities.device.model.DeviceEnv;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceEnvMapper {

    DeviceEnvMapper INSTANCE = Mappers.getMapper(DeviceEnvMapper.class);

    DeviceEnv createDeviceEnvDTOToDeviceEnv(CreateDeviceEnvDTO deviceEnvDTO);
}
