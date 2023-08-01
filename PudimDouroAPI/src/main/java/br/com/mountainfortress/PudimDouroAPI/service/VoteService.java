package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.constant.ErrorMessage;
import br.com.mountainfortress.PudimDouroAPI.dto.VoteDto;
import br.com.mountainfortress.PudimDouroAPI.exception.VoteException;
import br.com.mountainfortress.PudimDouroAPI.model.Inscription;
import br.com.mountainfortress.PudimDouroAPI.model.Vote;
import br.com.mountainfortress.PudimDouroAPI.repository.InscriptionRepository;
import br.com.mountainfortress.PudimDouroAPI.repository.VoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private ModelMapper modelMapper;

    public VoteDto registerVote(VoteDto dto) throws VoteException {
        Vote vote = modelMapper.map(dto, Vote.class);

        checkPreviousVote(vote);
        checkDifferentUsers(vote);
        checkInscription(vote);

        voteRepository.save(vote);
        return modelMapper.map(vote, VoteDto.class);
    }

    private void checkPreviousVote(Vote vote) throws VoteException {
        Vote previousVote = voteRepository.findByEditionAndUser(vote.getEdition(), vote.getUser());
        if(previousVote != null) throw new VoteException(ErrorMessage.DUPLICATE_VOTE);
    }

    private void checkDifferentUsers(Vote vote) throws VoteException {
        if(vote.getFirst_place().equals(vote.getSecond_place()) || vote.getFirst_place().equals(vote.getThird_place()) || vote.getSecond_place().equals(vote.getThird_place())){
            throw new VoteException(ErrorMessage.EQUAL_USERS);
        }
    }

    private void checkInscription(Vote vote) throws VoteException {
        Inscription checkFirstInscription = inscriptionRepository.findByUserAndEdition(vote.getFirst_place(), vote.getEdition());
        Inscription checkSecondInscription = inscriptionRepository.findByUserAndEdition(vote.getSecond_place(), vote.getEdition());
        Inscription checkThirdInscription = inscriptionRepository.findByUserAndEdition(vote.getThird_place(), vote.getEdition());
        if(checkFirstInscription == null || checkSecondInscription == null || checkThirdInscription == null) {
            throw new VoteException(ErrorMessage.NOT_SUBSCRIBED);
        }
    }
}
