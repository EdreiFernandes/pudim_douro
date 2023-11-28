package br.com.mountainfortress.pudimdouroapi.repository;

import br.com.mountainfortress.pudimdouroapi.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Query(value = "FROM UserProfile u WHERE u.email = :email")
    UserProfile findByEmail(@Param("email") String email);

    @Query(value = "FROM UserProfile u WHERE u.nickname = :nickname")
    UserProfile findByNickname(@Param("nickname") String nickname);
}
