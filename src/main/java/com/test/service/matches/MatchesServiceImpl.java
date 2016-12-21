package com.test.service.matches;

import com.test.model.MatchesEntity;
import com.test.service.matches.dto.MatchesWithDecodedTeamNames;
import com.test.service.matches.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;


@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class MatchesServiceImpl implements MatchesService {


    private MatchesRepository objRepository;
    public EntityManager em;




    @Autowired
    public void setTeamsRepository(MatchesRepository objRepository){
        this.objRepository=objRepository;
    }


    @Override
    public List<MatchesWithDecodedTeamNames> findAlls() {
        List<MatchesWithDecodedTeamNames> matches = objRepository.getMatchesWithDecodedTeamNames();
        return matches;
    }
    @Override
    public Collection<MatchesEntity> findAll() {
        Collection<MatchesEntity> objCollectionEntity = objRepository.findAll();
        return objCollectionEntity;
    }

    @Override
    public MatchesEntity findOne(Long id) {
        MatchesEntity objEntity = objRepository.findOne(id);
        return objEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public MatchesEntity create(MatchesEntity objEntity) {
        if (objEntity.getId() != null){
            //Cannot create Match with specified ID value
            return null;
        }
        MatchesEntity savedObjEntity = objRepository.save(objEntity);
        return savedObjEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public MatchesEntity update(MatchesEntity objEntity) {
        MatchesEntity teamsEntityPersisted = findOne(objEntity.getId());
        if (teamsEntityPersisted == null){
            //Cannot update Match that hasn't been persisted
            return null;
        }

        MatchesEntity updatedObjEntity = objRepository.save(objEntity);
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
