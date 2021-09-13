package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.model.DeviceEnv;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DeviceEnvRepository extends CrudRepository<DeviceEnv, Long> {

    @Modifying
    @Transactional
    @Query("delete from DeviceEnv d where d.name = :envName and d.device.id = :deviceId")
    void deleteInBulkByNameAndDeviceId(@Param("envName") String envName, @Param("deviceId") Long deviceId);
}
