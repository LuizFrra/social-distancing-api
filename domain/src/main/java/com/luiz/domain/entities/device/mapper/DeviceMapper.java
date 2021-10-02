package com.luiz.domain.entities.device.mapper;

import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import com.luiz.domain.entities.device.dto.DeviceDTO;
import com.luiz.domain.entities.device.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDTO deviceToDeviceDTO(Device device);

    Device createDeviceDTOToDevice(CreateDeviceDTO deviceDTO);
}
