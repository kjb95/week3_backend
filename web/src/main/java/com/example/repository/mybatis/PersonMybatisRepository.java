package com.example.repository.mybatis;

import com.example.domain.mybatis.Person;
import com.example.repository.mybatis.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonMybatisRepository implements PersonRepository {
    private final PersonMapper personMapper;

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            personMapper.save(person);
        } else {
            personMapper.update(person);
        }
        return person;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personMapper.findById(id);
    }

    @Override
    public void delete(Person person) {
        personMapper.delete(person);
    }
}
