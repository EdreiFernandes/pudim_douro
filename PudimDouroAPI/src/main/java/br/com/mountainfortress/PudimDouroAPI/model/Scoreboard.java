package br.com.mountainfortress.PudimDouroAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scoreboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String user;

    @NotNull
    private Integer gold_medal;

    @NotNull
    private Integer silver_medal;

    @NotNull
    private Integer bronze_medal;
}
