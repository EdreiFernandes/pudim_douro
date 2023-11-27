package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    private String email;
    private String name;
    private String surname;
    private String nickname;
    private String password;
    private String token;
}
