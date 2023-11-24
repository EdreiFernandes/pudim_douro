package br.com.mountainfortress.PudimDouroAPI.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto extends JsonableDto {
    private String email;
    private String name;
    private String surname;
    private String nickname;
    private String password;
    private boolean active;
}
