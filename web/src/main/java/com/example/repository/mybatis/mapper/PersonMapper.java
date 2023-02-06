package com.example.repository.mybatis.mapper;

import com.example.domain.mybatis.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface PersonMapper {
    void save(Person person);

    Optional<Person> findById(Long id);

    void update(Person person);

    void delete(Person person);
}
