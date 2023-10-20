package br.com.mountainfortress.PudimDouroAPI.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountedVote {
    private Integer user;
    private Long votesAtPosition;
}
