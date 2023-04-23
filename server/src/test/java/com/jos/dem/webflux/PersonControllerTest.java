package com.jos.dem.webflux;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.jos.dem.webflux.model.Person;
import com.jos.dem.webflux.controller.PersonController;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PersonControllerTest {

    private final WebTestClient webTestClient;

    @Test
    @DisplayName("getting all persons")
    void shouldGetPersons(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());
        webTestClient.get().uri("/persons").accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBodyList(Person.class);
    }

    @Test
    @DisplayName("getting person by nickname")
    void shouldGetPerson(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());
        webTestClient.get().uri("/persons/{nickname}", "josdem").accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody(Person.class);
    }

}
