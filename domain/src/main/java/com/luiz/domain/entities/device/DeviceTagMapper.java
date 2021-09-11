package com.luiz.domain.entities.device;

import com.luiz.domain.entities.device.dto.CreateDeviceTagDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceTagMapper {
    DeviceTagMapper INSTANCE = Mappers.getMapper(DeviceTagMapper.class);

    DeviceTag createDeviceTagDTOToDeviceTag(CreateDeviceTagDTO createDeviceTagDTO);
}
