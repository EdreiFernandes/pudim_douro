package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.dto.UserDto;
import br.com.mountainfortress.PudimDouroAPI.model.User;
import br.com.mountainfortress.PudimDouroAPI.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public  UserDto getUser(String email){
        Optional<User> result = repository.findById(email);
        if(result.isEmpty()) return null;

        return modelMapper.map(result, UserDto.class);
    }

    public UserDto createUser(UserDto dto){
        User user = modelMapper.map(dto, User.class);
        user.setActive(true);
        repository.save(user);

        return modelMapper.map(user, UserDto.class);
    }
}
