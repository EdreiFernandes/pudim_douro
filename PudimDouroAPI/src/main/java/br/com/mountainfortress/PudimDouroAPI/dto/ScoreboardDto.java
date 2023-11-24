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
public class ScoreboardDto extends JsonableDto {
    private String id;
    private String user;
    private String gold_medal;
    private String silver_medal;
    private String brass_medal;
}
