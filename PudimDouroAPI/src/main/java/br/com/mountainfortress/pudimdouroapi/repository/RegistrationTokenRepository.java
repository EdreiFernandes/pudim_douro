package br.com.mountainfortress.pudimdouroapi.repository;

import br.com.mountainfortress.pudimdouroapi.model.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Integer> {
    @Query(value = "FROM RegistrationToken rt WHERE rt.active = TRUE")
    List<RegistrationToken> findActive();
}
