package com.test.service.matches;

import com.test.model.MatchesEntity;
import com.test.service.matches.dto.MatchesWithDecodedTeamNames;

import java.util.Collection;
import java.util.List;

public interface MatchesService {
    List<MatchesWithDecodedTeamNames> findAlls();

    Collection<MatchesEntity> findAll();

    MatchesEntity findOne(Long id);

    MatchesEntity create(MatchesEntity teamsEntity);

    MatchesEntity update(MatchesEntity teamsEntity);

    void delete(Long id);
}
