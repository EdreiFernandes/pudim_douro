package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
