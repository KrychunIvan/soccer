package com.test.service.country;

import com.test.parser.dto.CountryFromWiki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.test.model.CountryEntity;
import com.test.service.country.repository.CountryRepository;



@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class CountryServiceImpl implements CountryService {


    private CountryRepository objRepository;



    @Autowired
    public void setTeamsRepository(CountryRepository objRepository){
        this.objRepository=objRepository;
    }



    @Override
    public Collection<CountryEntity> findAll() {

        Collection<CountryEntity> objCollectionEntity = objRepository.findAll();
        return objCollectionEntity;
    }

    @Override
    public CountryEntity findOne(Long id) {
        CountryEntity objEntity = objRepository.findOne(id);
        return objEntity;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public CountryEntity create(CountryEntity objEntity) {
        if (objEntity.getId() != null){
            //Cannot create Country with specified ID value
            return null;
        }
        CountryEntity savedObjEntity = objRepository.save(objEntity);
        return savedObjEntity;
    }
    private CountryEntity dtoToCountryEntity(CountryFromWiki dto){
        CountryEntity tempEntity = new CountryEntity();
        tempEntity.setAlpha2(dto.getAlpha2());
        tempEntity.setName(dto.getName());
        tempEntity.setCountryCode(dto.getCountry_code());
        tempEntity.setFlag(dto.getFlag());
        return create(tempEntity);
    }
    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public Collection<CountryEntity> createEntityWithParser(Map<Long,CountryFromWiki> countriesDTO){

        Long nextId = new Long(0);
        Map<Long,CountryEntity> countryEntityMap = new HashMap<Long, CountryEntity>();

        while (nextId < countriesDTO.size()) {
            countryEntityMap.put(nextId,dtoToCountryEntity(countriesDTO.get(nextId)));
            nextId += 1;
        }
        return countryEntityMap.values();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false)
    public CountryEntity update(CountryEntity objEntity) {
        CountryEntity teamsEntityPersisted = findOne(objEntity.getId());
        if (teamsEntityPersisted == null){
            //Cannot update Country that hasn't been persisted
            return null;
        }

        CountryEntity updatedObjEntity = objRepository.save(objEntity);
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
