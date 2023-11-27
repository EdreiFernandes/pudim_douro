package br.com.mountainfortress.pudimdouroapi.controller;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.dto.RegistrationTokenDto;
import br.com.mountainfortress.pudimdouroapi.service.RegistrationTokenService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/token")
public class RegistrationTokenController {

    @Autowired
    private RegistrationTokenService service;

    @GetMapping
    public ResponseEntity<String> getRegistrationToken(){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        RegistrationTokenDto token = service.getCurrentActiveToken();
//        if (token == null) return ResponseEntity.noContent().build();
//        return ResponseEntity.ok().body(token);
    }

    @PostMapping
    public ResponseEntity<String> createRegistrationToken(@RequestBody RegistrationTokenDto dto, UriComponentsBuilder uriBuilder){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        RegistrationTokenDto token = service.createRegistrationToken(dto);
//        URI address = uriBuilder.path("/api/token").buildAndExpand().toUri();
//
//        return ResponseEntity.created(address).body(token);
    }
}
