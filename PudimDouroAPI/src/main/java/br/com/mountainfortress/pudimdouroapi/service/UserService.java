package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.constant.SuccessMessage;
import br.com.mountainfortress.pudimdouroapi.dto.UserDto;
import br.com.mountainfortress.pudimdouroapi.exception.InscriptionException;
import br.com.mountainfortress.pudimdouroapi.model.Edition;
import br.com.mountainfortress.pudimdouroapi.model.Inscription;
import br.com.mountainfortress.pudimdouroapi.model.User;
import br.com.mountainfortress.pudimdouroapi.repository.EditionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.InscriptionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User result = userRepository.findByEmail(email);
        if(result == null) return null;

        return modelMapper.map(result, UserDto.class);
    }

    public  boolean usedNickname(String nickname){
        User result = userRepository.findByNickname(nickname);
        return result != null;
    }

    public UserDto createUser(UserDto dto){
        User user = modelMapper.map(dto, User.class);
        user.setActive(true);
        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public String inscriptionUserInCurrentEdition(UserDto dto) throws InscriptionException {
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null) throw new InscriptionException(ErrorMessage.USER_NOT_EXIST);

        Edition edition = editionRepository.findActive();
        if(edition == null) throw new InscriptionException(ErrorMessage.EDITION_NOT_EXIST);

        Inscription inscription = inscriptionRepository.findByUserAndEdition(user.getId(), edition.getId());
        if(inscription != null) throw new InscriptionException(ErrorMessage.REGISTERED_USER);

        inscription = new Inscription();
        inscription.setUser(user.getId());
        inscription.setEdition(edition.getId());
        inscriptionRepository.save(inscription);

        return SuccessMessage.INSCRIPTION;
    }
}
