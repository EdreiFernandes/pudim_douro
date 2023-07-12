package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.model.User;
import br.com.mountainfortress.PudimDouroAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto dto){
        User user = modelMapper.map(dto, User.class);
        user.setActive(true);
        repository.save(user);

        return modelMapper.map(user, UserDto.class);
    }
}