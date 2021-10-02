package com.luiz.infra.repositories;


import com.luiz.domain.entities.device.model.DeviceLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DeviceLogRepository extends ElasticsearchRepository<DeviceLog, String> {

}
