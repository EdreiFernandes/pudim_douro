package br.com.mountainfortress.pudimdouroapi.model;

import lombok.*;

import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EditionHistoryLine {
    private Integer id;
    private Year edition_year;
    private boolean active;
    private String first_place;
    private String second_place;
    private String third_place;
}
