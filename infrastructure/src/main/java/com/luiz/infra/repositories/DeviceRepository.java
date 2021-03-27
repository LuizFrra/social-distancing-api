package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    Optional<Device> findByIdentifier(String identifier);

}
