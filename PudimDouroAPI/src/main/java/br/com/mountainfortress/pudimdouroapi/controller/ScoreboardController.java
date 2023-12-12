package br.com.mountainfortress.pudimdouroapi.controller;

import br.com.mountainfortress.pudimdouroapi.dto.JsonableDto;
import br.com.mountainfortress.pudimdouroapi.dto.ScoreboardDto;
import br.com.mountainfortress.pudimdouroapi.service.ScoreboardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/scoreboard")
@CrossOrigin(origins = "*")
public class ScoreboardController {

    @Autowired
    private ScoreboardService service;

    @GetMapping
    public ResponseEntity<String> getScoreboard(){
        List<ScoreboardDto> scoreboard = service.getScoreboard();
        try {
            return ResponseEntity.ok().body(JsonableDto.toJson(scoreboard));
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
