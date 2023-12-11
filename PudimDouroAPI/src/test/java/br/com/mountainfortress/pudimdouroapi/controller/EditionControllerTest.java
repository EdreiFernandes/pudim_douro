//package br.com.mountainfortress.pudimdouroapi.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class EditionControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    void getEditionHistoryShouldReturnHistory() {
//        String url = "http://localhost:" + port + "/api/edition";
//        assertThat(
//                this.restTemplate.getForObject(url, String.class))
//                .contains("id")
//                .contains("edition_year")
//                .contains("active")
//                .contains("first_place")
//                .contains("second_place")
//                .contains("third_place");
//    }
//}
