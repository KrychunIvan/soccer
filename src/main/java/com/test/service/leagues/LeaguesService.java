package com.test.service.leagues;

import com.test.model.LeaguesEntity;

import java.util.Collection;

public interface LeaguesService {
    Collection<LeaguesEntity> findAll();

    LeaguesEntity findOne(Long id);

    LeaguesEntity create(LeaguesEntity teamsEntity);

    LeaguesEntity update(LeaguesEntity teamsEntity);

    void delete(Long id);
}
