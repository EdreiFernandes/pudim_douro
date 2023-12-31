package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.dto.ScoreboardDto;
import br.com.mountainfortress.pudimdouroapi.repository.ScoreboardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreboardService {

    @Autowired
    private ScoreboardRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ScoreboardDto> getScoreboard(){
        return repository
                .findWithUserName()
                .stream()
                .map(p -> modelMapper.map(p, ScoreboardDto.class))
                .toList();
    }
}
