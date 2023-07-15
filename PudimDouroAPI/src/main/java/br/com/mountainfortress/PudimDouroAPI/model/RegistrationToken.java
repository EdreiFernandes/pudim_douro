package br.com.mountainfortress.PudimDouroAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "registration_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 10)
    private String token;

    @NotNull
    private Timestamp validate;

    @NotNull
    private boolean active;
}
