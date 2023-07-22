package br.com.mountainfortress.PudimDouroAPI.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScoreboardDto {
    private String id;
    private String user;
    private String gold_medal;
    private String silver_medal;
    private String bronze_medal;
}
