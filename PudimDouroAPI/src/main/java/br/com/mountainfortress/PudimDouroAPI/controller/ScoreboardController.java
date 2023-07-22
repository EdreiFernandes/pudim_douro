package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.ScoreboardDto;
import br.com.mountainfortress.PudimDouroAPI.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/scoreboard")
public class ScoreboardController {

    @Autowired
    private ScoreboardService service;

    @GetMapping
    public ResponseEntity<String> getScoreboard(){
        List<ScoreboardDto> scoreboard = service.getScoreboard();
        return ResponseEntity.ok(scoreboard.toString());
    }
}
