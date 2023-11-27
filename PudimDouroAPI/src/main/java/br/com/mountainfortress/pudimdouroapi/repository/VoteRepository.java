package br.com.mountainfortress.pudimdouroapi.repository;

import br.com.mountainfortress.pudimdouroapi.model.CountedVote;
import br.com.mountainfortress.pudimdouroapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    String NEW_COUNTED_VOTE = "new br.com.mountainfortress.pudimdouroapi.model.CountedVote";

    @Query(value = "FROM Vote v WHERE v.edition = :edition_id and v.user = :user_id")
    Vote findByEditionAndUser(@Param("edition_id") Integer edition_id, @Param("user_id") Integer userId);

    @Query(value = "SELECT " + NEW_COUNTED_VOTE + "(first_place, COUNT(first_place)) FROM Vote v WHERE v.edition = :edition_id GROUP BY first_place ORDER BY first_place")
    List<CountedVote> countFirstPlaceInEdition(@Param("edition_id") Integer edition_id);

    @Query(value = "SELECT " + NEW_COUNTED_VOTE + "(second_place, COUNT(second_place)) FROM Vote v WHERE v.edition = :edition_id GROUP BY second_place ORDER BY second_place")
    List<CountedVote> countSecondPlaceInEdition(@Param("edition_id") Integer edition_id);

    @Query(value = "SELECT " + NEW_COUNTED_VOTE + "(third_place, COUNT(third_place)) FROM Vote v WHERE v.edition = :edition_id GROUP BY third_place ORDER BY third_place")
    List<CountedVote> countThirdPlaceInEdition(@Param("edition_id") Integer edition_id);
}
