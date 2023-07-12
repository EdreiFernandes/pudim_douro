package br.com.mountainfortress.PudimDouroAPI.service;

import br.com.mountainfortress.PudimDouroAPI.dto.RegistrationTokenDto;
import br.com.mountainfortress.PudimDouroAPI.model.RegistrationToken;
import br.com.mountainfortress.PudimDouroAPI.repository.RegistrationTokenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class RegistrationTokenService {

    @Autowired
    private RegistrationTokenRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public RegistrationTokenDto getValidToken() {
        return null;
    }

    public RegistrationTokenDto createRegistrationToken(RegistrationTokenDto dto) {
        RegistrationToken token = modelMapper.map(dto, RegistrationToken.class);
        token.setValidate(getOneMonthValidate());
        repository.save(token);

        return modelMapper.map(token, RegistrationTokenDto.class);
    }

    private Timestamp getOneMonthValidate(){
        LocalDate validate = LocalDate.now().plusMonths(1);
        return Timestamp.valueOf(validate.atTime(LocalTime.MIDNIGHT));
    }
}
