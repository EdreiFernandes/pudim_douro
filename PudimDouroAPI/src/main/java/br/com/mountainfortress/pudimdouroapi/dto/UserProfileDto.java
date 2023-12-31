package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfileDto extends JsonableDto {
    private String email;
    private String name;
    private String surname;
    private String nickname;
    private String password;
    private boolean active;
}
