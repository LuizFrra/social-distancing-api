package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Long> {

    Optional<Device> findByIdentifier(String identifier);

    boolean existsById(@NonNull Long deviceId);

}
