package com.luiz.infra.services.device;

import com.luiz.domain.entities.device.model.Device;
import com.luiz.domain.entities.device.model.DeviceLog;
import com.luiz.domain.infrastructure.services.device.InsertDeviceLogService;
import com.luiz.infra.repositories.DeviceLogRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InsertDeviceLogServiceImpl implements InsertDeviceLogService {

    private final DeviceLogRepository deviceLogRepository;

    public InsertDeviceLogServiceImpl(DeviceLogRepository deviceLogRepository) {
        this.deviceLogRepository = deviceLogRepository;
    }

    @Override
    public Device call(Device device) {
        Iterable<DeviceLog> logsToInsert = device.getLogs().stream()
                .filter(log -> StringUtils.isBlank(log.getId())).collect(Collectors.toList());
        Iterable<DeviceLog> savedLogsIterator = deviceLogRepository.saveAll(logsToInsert);
        List<DeviceLog> savedLogs = StreamSupport.stream(savedLogsIterator.spliterator(), false)
                .collect(Collectors.toList());
        device.setLogs(savedLogs);
        return device;
    }
}
