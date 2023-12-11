package br.com.mountainfortress.pudimdouroapi.service;

import br.com.mountainfortress.pudimdouroapi.dto.RegistrationTokenDto;
import br.com.mountainfortress.pudimdouroapi.model.RegistrationToken;
import br.com.mountainfortress.pudimdouroapi.repository.RegistrationTokenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class RegistrationTokenService {

    @Autowired
    private RegistrationTokenRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public RegistrationTokenDto getCurrentActiveToken() {
        RegistrationToken token = lookForActiveToken();
        if(token == null) return null;

        return modelMapper.map(token, RegistrationTokenDto.class);
    }

    public RegistrationTokenDto createRegistrationToken(RegistrationTokenDto dto) {
        inactivateLastToken();

        RegistrationToken token = modelMapper.map(dto, RegistrationToken.class);
        token.setValidate(getOneMonthValidate());
        token.setActive(true);
        repository.save(token);

        return modelMapper.map(token, RegistrationTokenDto.class);
    }

    private Timestamp getOneMonthValidate(){
        LocalDate validate = LocalDate.now().plusMonths(1);
        return Timestamp.valueOf(validate.atTime(LocalTime.MIDNIGHT));
    }

    private RegistrationToken lookForActiveToken(){
        List<RegistrationToken> tokens = repository.findActive();
        if(tokens.isEmpty()) return null;

        return tokens.get(0);
    }

    private void inactivateLastToken(){
        RegistrationToken lastToken = lookForActiveToken();
        if(lastToken != null) {
            lastToken.setActive(false);
            repository.save(lastToken);
        }
    }
}
