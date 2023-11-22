package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.EditionDto;
import br.com.mountainfortress.PudimDouroAPI.service.EditionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/edition")
public class EditionController {
    @Autowired
    private EditionService service;

    @GetMapping
    public ResponseEntity<String> getEditionHistory(){
        List<EditionDto> editions = service.getEditionHistory();
        try {
            return ResponseEntity.ok().body(EditionDto.toJson(editions));
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
