package com.luiz.domain.entities.device.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.time.Instant;
import java.util.Map;

@Document(indexName = "devices_log")
public class DeviceLog {

    @Id
    private String id;

    private Long timestamp = Instant.now().toEpochMilli();

    private Long deviceId;

    private Map<String, String> payload;

    public DeviceLog() {

    }

    public DeviceLog(String id, Long deviceId, Map<String, String> payload) {
        this.id = id;
        this.deviceId = deviceId;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
