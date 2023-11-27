package br.com.mountainfortress.pudimdouroapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EditionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getEditionHistoryShouldReturnHistory() {
        String url = "http://localhost:" + port + "/api/scoreboard";
        assertThat(
                this.restTemplate.getForObject(url, String.class))
                .contains("id")
                .contains("user")
                .contains("gold_medal")
                .contains("silver_medal")
                .contains("brass_medal");
    }
}
