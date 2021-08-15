package com.luiz.infra.integration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.luiz.domain")
@EnableJpaRepositories("com.luiz.infra")
@SpringBootApplication(scanBasePackages = "com.luiz.api")
public class CommonTestApplication {
}
