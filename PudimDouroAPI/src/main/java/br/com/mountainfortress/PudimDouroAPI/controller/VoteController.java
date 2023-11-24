package br.com.mountainfortress.PudimDouroAPI.controller;

import br.com.mountainfortress.PudimDouroAPI.constant.ErrorMessage;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.dto.VoteDto;
import br.com.mountainfortress.PudimDouroAPI.exception.VoteException;
import br.com.mountainfortress.PudimDouroAPI.model.CountedVote;
import br.com.mountainfortress.PudimDouroAPI.service.VoteService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);

//        List<CountedVote> finalVotes = service.countVotes();
//        return ResponseEntity.ok().body(finalVotes.toString());
    }

    @PostMapping
    public ResponseEntity<String> voting(@RequestBody VoteDto dto){
        var error = new ExecutionControl.NotImplementedException(ErrorMessage.AVAILABLE_SOON);
        return new ResponseEntity<>(error.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
        
//        try {
//            VoteDto vote = service.registerVote(dto);
//            return ResponseEntity.ok().body(vote.toString());
//        } catch (VoteException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
    }
}
