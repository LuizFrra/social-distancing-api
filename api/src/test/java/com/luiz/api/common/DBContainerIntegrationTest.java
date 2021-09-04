package com.luiz.api.common;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.function.Consumer;

import static com.github.dockerjava.api.model.Ports.Binding.bindPort;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(initializers = DBContainerIntegrationTest.Initializer.class)
public abstract class DBContainerIntegrationTest {

    private static Consumer<CreateContainerCmd> cmd = e -> e.withHostConfig(
            new HostConfig().withPortBindings(
                    new PortBinding(bindPort(5432), new ExposedPort(5432)
                    )
            ));

    @Container
    @ClassRule
    private static final PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:13-alpine")
            .withDatabaseName("social_distancing")
            .withUsername("social_distancing_user")
            .withPassword("social_distancing_password")
            .withCreateContainerCmdModifier(cmd);

    @BeforeAll
    void startContainer() {
        postgreSQLContainer.start();
    }

    @AfterAll
    void stopContainer() {
        if(!postgreSQLContainer.isShouldBeReused())
            postgreSQLContainer.stop();
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            postgreSQLContainer.start();
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}