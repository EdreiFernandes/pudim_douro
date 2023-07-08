package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
