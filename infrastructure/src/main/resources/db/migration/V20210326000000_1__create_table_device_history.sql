CREATE TABLE IF NOT EXISTS device_history (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    status VARCHAR(20),
    mode_update VARCHAR(20),
    status_date TIMESTAMP NOT NULL DEFAULT NOW(),
    reason VARCHAR(256),
    device_id BIGINT NOT NULL REFERENCES "device"
);