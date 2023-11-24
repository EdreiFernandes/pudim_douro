package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.constant.ErrorMessage;
import br.com.mountainfortress.PudimDouroAPI.constant.SuccessMessage;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.exception.InscriptionException;
import br.com.mountainfortress.PudimDouroAPI.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto dto, UriComponentsBuilder uriBuilder){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        UserDto user = service.createUser(dto);
//        URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();
//
//        return ResponseEntity.created(address).body(user);
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> inscription(@RequestBody UserDto dto){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        try {
//            String result = service.inscriptionUserInCurrentEdition(dto);
//            return ResponseEntity.ok().body(result);
//        } catch (InscriptionException e) {
//            return ResponseEntity.ok().body(e.getMessage());
//        }
    }
}
