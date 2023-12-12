package br.com.mountainfortress.pudimdouroapi.controller;

import br.com.mountainfortress.pudimdouroapi.dto.LoginDto;
import br.com.mountainfortress.pudimdouroapi.dto.SignupDto;
import br.com.mountainfortress.pudimdouroapi.dto.UserProfileDto;
import br.com.mountainfortress.pudimdouroapi.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.LoginException;
import java.net.URI;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/new")
    public ResponseEntity<String> createUserLogin(@RequestBody SignupDto dto, UriComponentsBuilder uriBuilder){
        try {
            UserProfileDto user = service.createUserLogin(dto);
            URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();

            return ResponseEntity.created(address).body(user.toJson());
        } catch (LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDto dto){
        try {
            UserProfileDto user = service.tryToLogin(dto);

            return ResponseEntity.accepted().body(user.toJson());
        } catch (LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
