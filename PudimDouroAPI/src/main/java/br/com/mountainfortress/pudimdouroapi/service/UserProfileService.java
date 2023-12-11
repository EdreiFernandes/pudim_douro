package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.constant.SuccessMessage;
import br.com.mountainfortress.pudimdouroapi.dto.UserProfileDto;
import br.com.mountainfortress.pudimdouroapi.exception.InscriptionException;
import br.com.mountainfortress.pudimdouroapi.model.Edition;
import br.com.mountainfortress.pudimdouroapi.model.Inscription;
import br.com.mountainfortress.pudimdouroapi.model.UserProfile;
import br.com.mountainfortress.pudimdouroapi.repository.EditionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.InscriptionRepository;
import br.com.mountainfortress.pudimdouroapi.repository.UserProfileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserProfileDto getUser(String email){
        UserProfile result = userRepository.findByEmail(email);
        if(result == null) return null;

        return modelMapper.map(result, UserProfileDto.class);
    }

    public boolean usedNickname(String nickname){
        UserProfile result = userRepository.findByNickname(nickname);
        return result != null;
    }

    public UserProfileDto createUser(UserProfileDto dto){
        UserProfile userProfile = modelMapper.map(dto, UserProfile.class);
        userProfile.setActive(true);
        userRepository.save(userProfile);

        return modelMapper.map(userProfile, UserProfileDto.class);
    }

    public String inscriptionUserInCurrentEdition(UserProfileDto dto) throws InscriptionException {
        UserProfile userProfile = userRepository.findByEmail(dto.getEmail());
        if(userProfile == null) throw new InscriptionException(ErrorMessage.USER_NOT_EXIST);

        Edition edition = editionRepository.findActive();
        if(edition == null) throw new InscriptionException(ErrorMessage.EDITION_NOT_EXIST);

        Inscription inscription = inscriptionRepository.findByUserAndEdition(userProfile.getId(), edition.getId());
        if(inscription != null) throw new InscriptionException(ErrorMessage.REGISTERED_USER);

        inscription = new Inscription();
        inscription.setUser_profile(userProfile.getId());
        inscription.setEdition(edition.getId());
        inscriptionRepository.save(inscription);

        return SuccessMessage.INSCRIPTION;
    }
}
