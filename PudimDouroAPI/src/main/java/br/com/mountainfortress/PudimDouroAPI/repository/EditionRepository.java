package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditionRepository extends JpaRepository<Edition, Integer> {
    @Query(value = "FROM Edition ed WHERE ed.active = TRUE")
    Edition findActive();
}
