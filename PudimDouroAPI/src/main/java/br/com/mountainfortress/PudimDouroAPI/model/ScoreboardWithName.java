package br.com.mountainfortress.PudimDouroAPI.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScoreboardWithName {
    private Integer id;
    private String user;
    private Integer gold_medal;
    private Integer silver_medal;
    private Integer brass_medal;
}
