package br.com.mountainfortress.pudimdouroapi.repository;

import br.com.mountainfortress.pudimdouroapi.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    @Query(value = "FROM Inscription i WHERE i.user_profile = :user_profile_id and i.edition = :edition_id")
    Inscription findByUserAndEdition(@Param("user_profile_id") Integer userProfileId, @Param("edition_id") Integer editionId);
}
