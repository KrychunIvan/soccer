package com.test.service.leagues.repository;

import com.test.model.LeaguesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaguesRepository extends JpaRepository<LeaguesEntity, Long> {
}
