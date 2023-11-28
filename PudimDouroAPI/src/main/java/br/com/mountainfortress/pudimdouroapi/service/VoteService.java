package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.dto.VoteDto;
import br.com.mountainfortress.pudimdouroapi.exception.VoteException;
import br.com.mountainfortress.pudimdouroapi.model.CountedVote;
import br.com.mountainfortress.pudimdouroapi.model.Edition;
import br.com.mountainfortress.pudimdouroapi.model.Inscription;
import br.com.mountainfortress.pudimdouroapi.model.Vote;
import br.com.mountainfortress.pudimdouroapi.repository.EditionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.InscriptionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.VoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private EditionRepository editionRepository;
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
        Vote previousVote = voteRepository.findByEditionAndUser(vote.getEdition(), vote.getUser_profile());
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

    public List<CountedVote> countVotes() {
        Edition edition = editionRepository.findActive();

        List<CountedVote> first = voteRepository.countFirstPlaceInEdition(edition.getId());
        List<CountedVote> second = voteRepository.countSecondPlaceInEdition(edition.getId());
        List<CountedVote> third = voteRepository.countThirdPlaceInEdition(edition.getId());

        // Colocando 'peso' nas posições
        first.forEach(vote -> vote.setVotesAtPosition(vote.getVotesAtPosition() * 3));
        second.forEach(vote -> vote.setVotesAtPosition(vote.getVotesAtPosition() * 2));

        List<CountedVote> finalVotes = new ArrayList<>();

        // Contando todos os pontos de acordo com os primeiros colocados
        for (CountedVote currentFirst : first) {
            var user = currentFirst.getUser_profile();

            CountedVote currentSecond = second.stream().filter(x -> x.getUser_profile().equals(user)).findFirst().orElse(null);
            CountedVote currentThird = third.stream().filter(x -> x.getUser_profile().equals(user)).findFirst().orElse(null);

            Long totalSecond = currentSecond != null ? currentSecond.getVotesAtPosition() : 0 ;
            Long totalThird = currentThird != null ? currentThird.getVotesAtPosition() : 0;
            var totalVotes = currentFirst.getVotesAtPosition() + totalSecond + totalThird;

            second.remove(currentSecond);
            third.remove(currentThird);

            finalVotes.add(new CountedVote(user, totalVotes));
        }

        // Contando todos os pontos de acordo com os segundo colocados
        for (CountedVote currentSecond : second) {
            var user = currentSecond.getUser_profile();

            CountedVote currentThird = third.stream().filter(x -> x.getUser_profile().equals(user)).findFirst().orElse(null);

            Long totalThird = currentThird != null ? currentThird.getVotesAtPosition() : 0;
            var totalVotes = currentSecond.getVotesAtPosition() + totalThird;

            third.remove(currentThird);

            finalVotes.add(new CountedVote(user, totalVotes));
        }

        // Contando todos os pontos de acordo com os terceiros colocados
        finalVotes.addAll(third);

        finalVotes.sort((v1, v2) -> Math.toIntExact(v2.getVotesAtPosition() - v1.getVotesAtPosition()));

        return finalVotes;
    }
}
