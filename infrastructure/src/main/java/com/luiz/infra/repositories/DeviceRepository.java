package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
}
