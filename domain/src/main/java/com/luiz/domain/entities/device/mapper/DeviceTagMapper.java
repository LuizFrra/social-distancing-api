package com.luiz.domain.entities.device.mapper;

import com.luiz.domain.entities.device.dto.CreateDeviceTagDTO;
import com.luiz.domain.entities.device.model.DeviceTag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceTagMapper {
    DeviceTagMapper INSTANCE = Mappers.getMapper(DeviceTagMapper.class);

    DeviceTag createDeviceTagDTOToDeviceTag(CreateDeviceTagDTO createDeviceTagDTO);
}
