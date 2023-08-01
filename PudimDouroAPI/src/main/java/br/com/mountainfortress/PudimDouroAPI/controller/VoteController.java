package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.dto.VoteDto;
import br.com.mountainfortress.PudimDouroAPI.exception.VoteException;
import br.com.mountainfortress.PudimDouroAPI.model.CountedVote;
import br.com.mountainfortress.PudimDouroAPI.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private VoteService service;

    @GetMapping
    public ResponseEntity<String> getWinner(){
        List<CountedVote> finalVotes = service.countVotes();
        return ResponseEntity.ok().body(finalVotes.toString());
    }

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
