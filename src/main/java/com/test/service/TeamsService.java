package com.test.service;


import com.test.model.TeamsEntity;

import java.util.Collection;

public interface TeamsService {
    Collection<TeamsEntity> findAll();

    TeamsEntity findOne(Long id);

    TeamsEntity create(TeamsEntity teamsEntity);

    TeamsEntity update(TeamsEntity teamsEntity);

    void delete(Long id);
}
