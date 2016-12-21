package com.test.service.country;

import com.test.model.CountryEntity;
import com.test.parser.dto.CountryFromWiki;

import java.util.Collection;
import java.util.Map;

public interface CountryService {
    Collection<CountryEntity> findAll();

    CountryEntity findOne(Long id);

    CountryEntity create(CountryEntity teamsEntity);

    CountryEntity update(CountryEntity teamsEntity);

    void delete(Long id);

    Collection<CountryEntity> createEntityWithParser(Map<Long,CountryFromWiki> countries);
}
