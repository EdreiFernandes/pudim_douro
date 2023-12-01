package br.com.mountainfortress.pudimdouroapi.repository;

import br.com.mountainfortress.pudimdouroapi.model.Edition;
import br.com.mountainfortress.pudimdouroapi.model.EditionHistoryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EditionRepository extends JpaRepository<Edition, Integer> {

    String NEW_EDITION_HISTORY_LINE = "new br.com.mountainfortress.pudimdouroapi.model.EditionHistoryLine";

    @Query(value = "FROM Edition e WHERE e.active = TRUE")
    Edition findActive();

    @Query(value = "SELECT " + NEW_EDITION_HISTORY_LINE +
            "(e.id, e.edition_year, e.active, " +
            "COALESCE(u_first_place.nickname, 'Unknown'), " +
            "COALESCE(u_second_place.nickname, 'Unknown'), " +
            "COALESCE(u_third_place.nickname, 'Unknown')) " +
            "FROM Edition e " +
            "LEFT JOIN UserProfile u_first_place ON e.first_place = u_first_place.id " +
            "LEFT JOIN UserProfile u_second_place ON e.second_place = u_second_place.id " +
            "LEFT JOIN UserProfile u_third_place ON e.third_place = u_third_place.id " +
            "WHERE e.active = FALSE " +
            "ORDER BY e.id DESC")
    List<EditionHistoryLine> findHistory();
}
