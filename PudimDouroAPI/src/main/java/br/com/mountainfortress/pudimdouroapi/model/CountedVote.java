package br.com.mountainfortress.pudimdouroapi.model;

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
