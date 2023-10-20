package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.constant.SuccessMessage;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.exception.InscriptionException;
import br.com.mountainfortress.PudimDouroAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> test(){
        List<UserDto> list = new ArrayList<>();

        UserDto dto = service.getUser("edrei@teste.com");

        list.add(dto);

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto, UriComponentsBuilder uriBuilder){
        UserDto user = service.createUser(dto);
        URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();

        return ResponseEntity.created(address).body(user);
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> inscription(@RequestBody UserDto dto){
        try {
            String result = service.inscriptionUserInCurrentEdition(dto);
            return ResponseEntity.ok().body(result);
        } catch (InscriptionException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
