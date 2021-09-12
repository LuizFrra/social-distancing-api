package com.luiz.infra.services.device;

import com.luiz.domain.infrastructure.services.device.DeleteDeviceTagService;
import com.luiz.infra.repositories.DeviceTagRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteDeviceTagServiceImpl implements DeleteDeviceTagService {
    private final DeviceTagRepository deviceTagRepository;

    public DeleteDeviceTagServiceImpl(DeviceTagRepository deviceTagRepository) {
        this.deviceTagRepository = deviceTagRepository;
    }

    @Override
    public void call(Long deviceId, String deviceTag) {
        deviceTagRepository.deleteInBulkByNameAndDeviceId(deviceTag, deviceId);
    }
}
