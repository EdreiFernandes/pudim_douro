package br.com.mountainfortress.PudimDouroAPI.repository;

import br.com.mountainfortress.PudimDouroAPI.model.Scoreboard;
import br.com.mountainfortress.PudimDouroAPI.model.ScoreboardWithName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Integer> {

    String NEW_SCOREBOARD_WITH_NAME = "new br.com.mountainfortress.PudimDouroAPI.model.ScoreboardWithName";

    @Query(value = "SELECT " + NEW_SCOREBOARD_WITH_NAME +
            "(s.id, u.name, s.gold_medal, s.silver_medal, s.brass_medal)" +
            "FROM Scoreboard s INNER JOIN User u ON u.id = s.user")
    List<ScoreboardWithName> findWithUserName();
}
