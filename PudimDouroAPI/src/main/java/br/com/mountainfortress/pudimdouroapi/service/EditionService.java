package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.dto.EditionDto;
import br.com.mountainfortress.pudimdouroapi.repository.EditionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionService {

    @Autowired
    private EditionRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EditionDto> getEditionHistory(){
        return repository
                .findHistory()
                .stream()
                .map(p -> modelMapper.map(p, EditionDto.class))
                .toList();
    }
}
