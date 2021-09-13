package com.luiz.infra.repositories;

import com.luiz.domain.entities.device.model.DeviceTag;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface DeviceTagRepository extends CrudRepository<DeviceTag, Long> {

    @Modifying
    @Transactional
    @Query("delete from DeviceTag d where d.name = :tagName and d.device.id = :deviceId")
    void deleteInBulkByNameAndDeviceId(@Param("tagName") String tagName, @Param("deviceId") Long deviceId);
}
