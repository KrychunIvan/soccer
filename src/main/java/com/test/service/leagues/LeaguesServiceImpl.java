package com.test.service.leagues;

import com.test.model.LeaguesEntity;
import com.test.service.leagues.LeaguesService;
import com.test.service.leagues.repository.LeaguesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class LeaguesServiceImpl implements LeaguesService {


    private LeaguesRepository objRepository;



    @Autowired
    public void setTeamsRepository(LeaguesRepository objRepository){
        this.objRepository=objRepository;
    }



    @Override
    public Collection<LeaguesEntity> findAll() {

        Collection<LeaguesEntity> objCollectionEntity = objRepository.findAll();
        return objCollectionEntity;
    }

    @Override
    public LeaguesEntity findOne(Long id) {
        LeaguesEntity objEntity = objRepository.findOne(id);
        return objEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public LeaguesEntity create(LeaguesEntity objEntity) {
        if (objEntity.getId() != null){
            //Cannot create League with specified ID value
            return null;
        }
        LeaguesEntity savedObjEntity = objRepository.save(objEntity);
        return savedObjEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public LeaguesEntity update(LeaguesEntity objEntity) {
        LeaguesEntity teamsEntityPersisted = findOne(objEntity.getId());
        if (teamsEntityPersisted == null){
            //Cannot update League that hasn't been persisted
            return null;
        }

        LeaguesEntity updatedObjEntity = objRepository.save(objEntity);
        return updatedObjEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public void delete(Long id) {

        objRepository.delete(id);
    }
}
