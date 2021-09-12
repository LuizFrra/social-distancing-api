package com.luiz.domain.infrastructure.services.device;

public interface DeleteDeviceEnvService {
    void call(Long deviceId, String envName);
}
