package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.dto.LoginDto;
import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserDto createUserLogin(LoginDto dto) throws LoginException {
        String currentToken = tokenService.getCurrentActiveToken().getToken();
        if(!currentToken.equals(dto.getToken())) throw new LoginException("Token is not valid!");
        if(userService.getUser(dto.getEmail()) != null) throw new LoginException("E-mail already registered!");

        UserDto user = modelMapper.map(dto, UserDto.class);
        user.setName(user.getEmail().split("@")[0]);
        return userService.createUser(user);
    }
}
