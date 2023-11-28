package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.constant.ErrorMessage;
import br.com.mountainfortress.pudimdouroapi.dto.LoginDto;
import br.com.mountainfortress.pudimdouroapi.dto.RegistrationTokenDto;
import br.com.mountainfortress.pudimdouroapi.dto.SignupDto;
import br.com.mountainfortress.pudimdouroapi.dto.UserProfileDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class LoginService {

    @Autowired
    private RegistrationTokenService tokenService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserProfileDto createUserLogin(SignupDto dto) throws LoginException {
        RegistrationTokenDto currentToken = tokenService.getCurrentActiveToken();
        if(currentToken == null || !currentToken.getToken().equals(dto.getToken())) throw new LoginException(ErrorMessage.INVALID_TOKEN);
        if(userProfileService.getUser(dto.getEmail()) != null) throw new LoginException(ErrorMessage.REGISTERED_EMAIL);
        if(userProfileService.usedNickname(dto.getNickname())) throw new LoginException(ErrorMessage.USED_NICKNAME);

        UserProfileDto userProfile = modelMapper.map(dto, UserProfileDto.class);
        userProfile.setName(dto.getName());
        userProfile.setSurname(dto.getSurname());
        userProfile.setNickname(dto.getNickname());
        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        return userProfileService.createUser(userProfile);
    }

    public UserProfileDto tryToLogin(LoginDto dto) throws LoginException {
        UserProfileDto userProfile = userProfileService.getUser(dto.getEmail());

        boolean wrongLogin = userProfile == null ||
                !userProfile.isActive() ||
                !passwordEncoder.matches(dto.getPassword(), userProfile.getPassword());

        if(wrongLogin) throw new LoginException(ErrorMessage.WRONG_LOGIN);
        userProfile.setPassword(null);
        return userProfile;
    }
}
