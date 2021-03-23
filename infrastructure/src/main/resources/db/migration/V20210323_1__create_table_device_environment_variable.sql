CREATE TABLE IF NOT EXISTS device_environment_variable (
    id SERIAL NOT NULL,
    name VARCHAR(64) NOT NULL,
    "value" VARCHAR(256) NOT NULL,
    device_id BIGINT NOT NULL references "device",
    PRIMARY KEY(id, device_id)
);