package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.exception.InscriptionException;
import br.com.mountainfortress.PudimDouroAPI.model.Edition;
import br.com.mountainfortress.PudimDouroAPI.model.Inscription;
import br.com.mountainfortress.PudimDouroAPI.model.User;
import br.com.mountainfortress.PudimDouroAPI.repository.EditionRepository;
import br.com.mountainfortress.PudimDouroAPI.repository.InscriptionRepository;
import br.com.mountainfortress.PudimDouroAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public  UserDto getUser(String email){
        Optional<User> result = userRepository.findById(email);
        if(result.isEmpty()) return null;

        return modelMapper.map(result, UserDto.class);
    }

    public UserDto createUser(UserDto dto){
        User user = modelMapper.map(dto, User.class);
        user.setActive(true);
        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public String inscriptionUserInCurrentEdition(UserDto dto) throws InscriptionException {
        UserDto user = getUser(dto.getEmail());
        if(user == null) throw new InscriptionException("This user does not exist");

        Edition edition = editionRepository.findByActive();
        if(edition == null) throw new InscriptionException("There is no open edition");

        Inscription inscription = inscriptionRepository.findActiveByUserAndEdition(dto.getEmail(), edition.getId());
        if(inscription != null) throw new InscriptionException("User is already registered");

        inscription = new Inscription();
        inscription.setUser(dto.getEmail());
        inscription.setEdition(edition.getId());
        inscriptionRepository.save(inscription);

        return "Successful registration";
    }
}
