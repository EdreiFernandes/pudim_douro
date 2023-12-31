package br.com.mountainfortress.pudimdouroapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer user_profile;
    @NotNull
    private Integer edition;
    @NotNull
    private Integer first_place;
    @NotNull
    private Integer second_place;
    @NotNull
    private Integer third_place;
}
