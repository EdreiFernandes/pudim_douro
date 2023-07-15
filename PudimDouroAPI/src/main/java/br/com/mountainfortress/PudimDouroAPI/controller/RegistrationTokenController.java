package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.RegistrationTokenDto;
import br.com.mountainfortress.PudimDouroAPI.service.RegistrationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/token")
public class RegistrationTokenController {

    @Autowired
    private RegistrationTokenService service;

    @GetMapping
    public ResponseEntity<RegistrationTokenDto>  getRegistrationToken(){
        RegistrationTokenDto token = service.getCurrentActiveToken();
        if (token == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(token);
    }

    @PostMapping
    public ResponseEntity<RegistrationTokenDto> createRegistrationToken(@RequestBody RegistrationTokenDto dto, UriComponentsBuilder uriBuilder){
        RegistrationTokenDto token = service.createRegistrationToken(dto);
        URI address = uriBuilder.path("/api/token").buildAndExpand().toUri();

        return ResponseEntity.created(address).body(token);
    }
}
