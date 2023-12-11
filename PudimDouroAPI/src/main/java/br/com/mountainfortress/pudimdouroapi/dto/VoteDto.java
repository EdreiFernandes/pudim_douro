package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VoteDto {
    private String id;
    private String user_profile;
    private String edition;
    private String first_place;
    private String second_place;
    private String third_place;
}
