package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.VoteDto;
import br.com.mountainfortress.PudimDouroAPI.exception.VoteException;
import br.com.mountainfortress.PudimDouroAPI.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private VoteService service;

    @PostMapping
    public ResponseEntity<String> voting(@RequestBody VoteDto dto){
        try {
            VoteDto vote = service.registerVote(dto);
            return ResponseEntity.ok().body(vote.toString());
        } catch (VoteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
