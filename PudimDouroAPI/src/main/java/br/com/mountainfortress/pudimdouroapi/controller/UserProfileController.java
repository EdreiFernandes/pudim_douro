package br.com.mountainfortress.pudimdouroapi.controller;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.dto.UserProfileDto;
import br.com.mountainfortress.pudimdouroapi.service.UserProfileService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserProfileDto dto, UriComponentsBuilder uriBuilder){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        UserDto user = service.createUser(dto);
//        URI address = uriBuilder.path("/api/user/{email}").buildAndExpand(user.getEmail()).toUri();
//
//        return ResponseEntity.created(address).body(user);
    }

    @PostMapping("/inscription")
    public ResponseEntity<String> inscription(@RequestBody UserProfileDto dto){
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
