package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("It Works");
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto, UriComponentsBuilder uriBuilder){
        UserDto user = service.createUser(dto);
        URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();

        return ResponseEntity.created(address).body(user);
    }
}
