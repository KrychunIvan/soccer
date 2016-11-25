package com.test.service.repository;

import com.test.model.TeamsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<TeamsEntity, Long> {
}
