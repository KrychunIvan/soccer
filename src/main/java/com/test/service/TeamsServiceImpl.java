package com.test.service;

import com.test.model.TeamsEntity;
import com.test.service.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import java.util.Collection;


@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class TeamsServiceImpl implements TeamsService {


    private TeamsRepository teamsRepository;



    @Autowired
    public void setTeamsRepository(TeamsRepository teamsRepository){
        this.teamsRepository=teamsRepository;
    }



    @Override
    public Collection<TeamsEntity> findAll() {

        Collection<TeamsEntity> teamses = teamsRepository.findAll();
        return teamses;
    }

    @Override
    public TeamsEntity findOne(Long id) {
        TeamsEntity teamsEntity = teamsRepository.findOne(id);
        return teamsEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public TeamsEntity create(TeamsEntity teamsEntity) {
        if (teamsEntity.getId() != null){
            //Cannot create Greeting with specified ID value
            return null;
        }
        TeamsEntity savedTeamsEntity = teamsRepository.save(teamsEntity);
        return savedTeamsEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public TeamsEntity update(TeamsEntity teamsEntity) {
        TeamsEntity teamsEntityPersisted = findOne(teamsEntity.getId());
        if (teamsEntityPersisted == null){
            //Cannot update Greeting that hasn't been persisted
            return null;
        }

        TeamsEntity updatedTeamsEntity = teamsRepository.save(teamsEntity);
        return updatedTeamsEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public void delete(Long id) {

      teamsRepository.delete(id);
    }
}
