package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.LoginDto;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.LoginException;
import java.net.URI;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/new")
    public ResponseEntity<String> createUserLogin(@RequestBody LoginDto dto, UriComponentsBuilder uriBuilder){
        try {
            UserDto user = service.createUserLogin(dto);
            URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();

            return ResponseEntity.created(address).body(user.toString());
        } catch (LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDto dto){
        try {
            UserDto user = service.tryToLogin(dto);

            return ResponseEntity.accepted().body(user.toJson());
        } catch (LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
