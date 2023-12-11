package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditionDto extends JsonableDto{
    private String id;
    private String edition_year;
    private String active;
    private String first_place;
    private String second_place;
    private String third_place;
}
