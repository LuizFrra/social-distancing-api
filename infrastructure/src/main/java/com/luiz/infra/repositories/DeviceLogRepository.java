package com.luiz.infra.repositories;


import com.luiz.domain.entities.device.model.DeviceLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Collection;

public interface DeviceLogRepository extends ElasticsearchRepository<DeviceLog, String> {
    Collection<DeviceLog> findByDeviceId(Long deviceId);
}
