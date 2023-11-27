package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationTokenDto {
    private String token;
    private String validate;
}
