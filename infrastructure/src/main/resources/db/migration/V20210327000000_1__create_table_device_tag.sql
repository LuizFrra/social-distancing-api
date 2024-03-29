CREATE TABLE IF NOT EXISTS device_tag (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    device_id BIGINT NOT NULL references "device",
    UNIQUE(name, device_id)
);