//package br.com.mountainfortress.pudimdouroapi.controller;
//
//import br.com.mountainfortress.pudimdouroapi.dto.LoginDto;
//import br.com.mountainfortress.pudimdouroapi.dto.SignupDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class LoginControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    void loginWithRightUserShouldReturnAnUser() {
//        String url = "http://localhost:" + port + "/api/login";
//
//        LoginDto dto = new LoginDto();
//        dto.setEmail("user1@teste.com");
//        dto.setPassword("123456");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("email")
//                .contains("name")
//                .contains("surname")
//                .contains("nickname")
//                .contains("password")
//                .contains("active");
//    }
//
//    @Test
//    void loginWithWrongUserShouldReturnError() {
//        String url = "http://localhost:" + port + "/api/login";
//
//        LoginDto dto = new LoginDto();
//        dto.setEmail("wrongUser@teste.com");
//        dto.setPassword("123456");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("Wrong email or password!");
//    }
//
//    @Test
//    void loginWithWrongPasswordShouldReturnError() {
//        String url = "http://localhost:" + port + "/api/login";
//
//        LoginDto dto = new LoginDto();
//        dto.setEmail("wrongUser@teste.com");
//        dto.setPassword("123456");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("Wrong email or password!");
//    }
//
//    @Test
//    void newLoginWrongTokenShouldReturnError() {
//        String url = "http://localhost:" + port + "/api/login/new";
//
//        SignupDto dto = new SignupDto();
//        dto.setEmail("newUser@teste.com");
//        dto.setName("Name");
//        dto.setSurname("Surname");
//        dto.setNickname("unique nick");
//        dto.setPassword("123");
//        dto.setToken("dev_error");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("Token is not valid!");
//    }
//
//    @Test
//    void newLoginUsedEmailShouldReturnError() {
//        String url = "http://localhost:" + port + "/api/login/new";
//
//        SignupDto dto = new SignupDto();
//        dto.setEmail("user1@teste.com");
//        dto.setName("Name");
//        dto.setSurname("Surname");
//        dto.setNickname("unique nick");
//        dto.setPassword("123");
//        dto.setToken("dev_test");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("E-mail already registered!");
//    }
//
//    @Test
//    void newLoginUsedNicknameShouldReturnError() {
//        String url = "http://localhost:" + port + "/api/login/new";
//
//        SignupDto dto = new SignupDto();
//        dto.setEmail("newUser@teste.com");
//        dto.setName("Name");
//        dto.setSurname("Surname");
//        dto.setNickname("One");
//        dto.setPassword("123");
//        dto.setToken("dev_test");
//
//        assertThat(
//                this.restTemplate.postForObject(url, dto, String.class))
//                .contains("Nickname already used!");
//    }
//}
