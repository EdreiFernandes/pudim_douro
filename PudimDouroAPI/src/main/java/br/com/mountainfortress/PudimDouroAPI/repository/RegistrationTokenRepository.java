package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Integer> {
    @Query(value = "FROM RegistrationToken rt WHERE rt.active = TRUE")
    List<RegistrationToken> findActiveToken();
}
