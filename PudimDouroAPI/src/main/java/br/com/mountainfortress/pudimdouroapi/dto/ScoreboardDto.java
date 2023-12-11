package br.com.mountainfortress.pudimdouroapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScoreboardDto extends JsonableDto {
    private String id;
    private String user_profile;
    private String gold_medal;
    private String silver_medal;
    private String brass_medal;
}
