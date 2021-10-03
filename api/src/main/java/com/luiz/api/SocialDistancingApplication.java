package com.luiz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@EntityScan("com.luiz.domain")
@EnableJpaRepositories("com.luiz.infra")
@EnableElasticsearchRepositories("com.luiz.infra")
@SpringBootApplication(scanBasePackages = "com.luiz.*")
public class SocialDistancingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialDistancingApplication.class, args);
	}

}
