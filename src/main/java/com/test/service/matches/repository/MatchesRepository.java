package com.test.service.matches.repository;

import com.test.model.MatchesEntity;
import com.test.model.TeamsEntity;
import com.test.service.matches.dto.MatchesWithDecodedTeamNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MatchesRepository extends JpaRepository<MatchesEntity, Long> {
    /*@Query("SELECT r.id, th.name AS homename, ta.name AS awayname, r.dateTime,r.homescore, r.awayscore FROM MatchesEntity r JOIN TeamsEntity th ON th.id = r.hometeamid JOIN TeamsEntity ta ON ta.id = r.awayteamid ORDER BY r.id ")
    Collection<MatchesEntity> findAllViewForm();*/
    @Query("select new com.test.service.matches.dto.MatchesWithDecodedTeamNames(r.id,th.name,ta.name,r.homescore,r.awayscore) from MatchesEntity r, TeamsEntity th,TeamsEntity ta where r.hometeamid = th.id and r.awayteamid=ta.id")
    List<MatchesWithDecodedTeamNames> getMatchesWithDecodedTeamNames();
}
