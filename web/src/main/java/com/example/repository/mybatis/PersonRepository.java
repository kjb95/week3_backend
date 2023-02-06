package com.example.repository.mybatis;

import com.example.domain.mybatis.Person;

import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);

    Optional<Person> findById(Long id);

    void delete(Person person);
}
