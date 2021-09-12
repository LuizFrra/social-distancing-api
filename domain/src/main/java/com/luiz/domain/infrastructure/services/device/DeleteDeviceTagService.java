package com.luiz.domain.infrastructure.services.device;

public interface DeleteDeviceTagService {
    void call(Long deviceId, String deviceTag);
}
