package br.com.mountainfortress.pudimdouroapi.controller;

import br.com.mountainfortress.pudimdouroapi.dto.EditionDto;
import br.com.mountainfortress.pudimdouroapi.dto.JsonableDto;
import br.com.mountainfortress.pudimdouroapi.service.EditionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/edition")
@CrossOrigin(origins = "*")
public class EditionController {
    @Autowired
    private EditionService service;

    @GetMapping
    public ResponseEntity<String> getEditionHistory(){
        List<EditionDto> editions = service.getEditionHistory();
        try {
            return ResponseEntity.ok().body(JsonableDto.toJson(editions));
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
