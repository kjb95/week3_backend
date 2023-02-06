package com.example.repository.jpa;

import com.example.domain.jpa.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
