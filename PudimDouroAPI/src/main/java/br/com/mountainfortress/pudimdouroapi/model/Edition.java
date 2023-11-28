package br.com.mountainfortress.pudimdouroapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Entity
@Table(name = "edition")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String edition_year;

    @NotNull
    private boolean active;

    private Integer first_place;

    private Integer second_place;

    private Integer third_place;
}
