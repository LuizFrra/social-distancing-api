package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.DeviceEnv;
import org.springframework.data.repository.CrudRepository;

public interface DeviceEnvRepository extends CrudRepository<DeviceEnv, Long> {
}
