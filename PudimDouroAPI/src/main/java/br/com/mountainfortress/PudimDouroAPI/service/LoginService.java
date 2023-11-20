package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.constant.ErrorMessage;
import br.com.mountainfortress.PudimDouroAPI.dto.LoginDto;
import br.com.mountainfortress.PudimDouroAPI.dto.RegistrationTokenDto;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
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
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto createUserLogin(LoginDto dto) throws LoginException {
        RegistrationTokenDto currentToken = tokenService.getCurrentActiveToken();
        if(currentToken == null || !currentToken.getToken().equals(dto.getToken())) throw new LoginException(ErrorMessage.INVALID_TOKEN);
        if(userService.getUser(dto.getEmail()) != null) throw new LoginException(ErrorMessage.REGISTERED_EMAIL);

        UserDto user = modelMapper.map(dto, UserDto.class);
        user.setName(user.getEmail().split("@")[0]);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.createUser(user);
    }

    public UserDto tryToLogin(LoginDto dto) throws LoginException {
        UserDto user = userService.getUser(dto.getEmail());

        boolean wrongLogin = user == null ||
                !user.isActive() ||
                !passwordEncoder.matches(dto.getPassword(), user.getPassword());

        if(wrongLogin) throw new LoginException(ErrorMessage.WRONG_LOGIN);
        user.setPassword(null);
        return user;
    }
}
