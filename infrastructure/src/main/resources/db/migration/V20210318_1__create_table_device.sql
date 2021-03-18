CREATE TABLE IF NOT EXISTS device (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  status VARCHAR(20),
  device_identifier VARCHAR(20) UNIQUE,
  "key" varchar(256) UNIQUE
);
