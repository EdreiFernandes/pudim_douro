package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Query(value = "FROM Vote v WHERE v.edition = :edition_id and v.user = :user_id")
    Vote findByEditionAndUser(@Param("edition_id") Integer edition_id, @Param("user_id") Integer userId);
}
