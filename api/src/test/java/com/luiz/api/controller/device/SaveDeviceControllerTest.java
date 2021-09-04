package com.luiz.api.controller.device;

import com.luiz.api.common.BaseControllerTest;
import com.luiz.domain.entities.device.DeviceStatus;
import com.luiz.domain.entities.device.dto.CreateDeviceDTO;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

@AutoConfigureMockMvc
@SuppressWarnings("java:S2699")
class SaveDeviceControllerTest extends BaseControllerTest {

    @Test
    void shouldCreateDeviceWhenSendRequestWithValidIdentifier() {
        String identifier = UUID.randomUUID().toString().substring(0, 8);
        CreateDeviceDTO createDeviceDTO = new CreateDeviceDTO(identifier);
        givenJson()
                .body(createDeviceDTO)
                .contentType(ContentType.JSON)
                .post("/api/v1/device")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body(
                        "$", hasKey("id"),
                        "identifier", equalTo(identifier),
                        "status", equalTo(DeviceStatus.BLOCKED.toString())
                );
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsEmptyPTBR() {
        validateDeviceCreationErrorMessage("", "pt-BR", "O campo identifier e obrigatorio");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierEmptyUS() {
        validateDeviceCreationErrorMessage("", "us", "field identifier is required");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsNullPTBR() {
        validateDeviceCreationErrorMessage(null, "pt-BR", "O campo identifier e obrigatorio");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsNullUS() {
        validateDeviceCreationErrorMessage(null, "us", "field identifier is required");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsBlankPTBR() {
        validateDeviceCreationErrorMessage(" ", "pt-BR", "O campo identifier e obrigatorio");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsBlankUS() {
        validateDeviceCreationErrorMessage(" ", "us", "field identifier is required");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsBiggerThen20PTBR() {
        validateDeviceCreationErrorMessage("a".repeat(21), "pt-BR", "identificador do device deve estar entre 1 e 20");
    }

    @Test
    void shouldNotCreateDeviceIfDeviceIdentifierIsBiggerThen20US() {
        validateDeviceCreationErrorMessage("a".repeat(21), "us", "identifier device must be between 1 and 20");
    }

    void validateDeviceCreationErrorMessage(String identifier, String language, String expectedMessage) {
        CreateDeviceDTO createDeviceDTO = new CreateDeviceDTO(identifier);
        givenJson()
                .body(createDeviceDTO)
                .header(new Header("Accept-Language", language))
                .contentType(ContentType.JSON)
                .post("/api/v1/device")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body(
                        "$", hasKey("identifier"),
                        "identifier", equalTo(expectedMessage)
                );
    }
}
