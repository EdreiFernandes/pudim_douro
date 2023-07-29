package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    @Query(value = "FROM Inscription in WHERE in.user = :email and in.edition = :edition")
    Inscription findActiveByUserAndEdition(@Param("email") String email, @Param("edition") Integer editionId);
}
