package com.luiz.domain.entities.device;

import com.luiz.domain.entities.device.dto.DeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO deviceToDeviceDTO(Device device);
}
