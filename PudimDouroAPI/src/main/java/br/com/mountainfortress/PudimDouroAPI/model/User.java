package br.com.mountainfortress.PudimDouroAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Size(max = 50)
    private String email;
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 20)
    private String password;

    @NotNull
    private boolean active;
}
