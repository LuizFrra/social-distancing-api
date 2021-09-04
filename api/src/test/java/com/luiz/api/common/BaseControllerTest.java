package com.luiz.api.common;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@SuppressWarnings("java:S2187")
public class BaseControllerTest extends DBContainerIntegrationTest {
    @Autowired
    private WebApplicationContext webContext;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webContext);
    }

    protected MockMvcRequestSpecification given() {
        return RestAssuredMockMvc.given();
    }

    protected MockMvcRequestSpecification givenJson() {
        return RestAssuredMockMvc.given().contentType(ContentType.JSON);
    }
}
