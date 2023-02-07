package com.example.service.mybatis;

import com.example.domain.mybatis.Person;
import com.example.dto.CreatePersonRequestDto;
import com.example.dto.FindPersonResponseDto;
import com.example.dto.UpdatePersonRequestDto;
import com.example.repository.mybatis.PersonMybatisRepository;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonMybatisService implements PersonService {
    private final PersonMybatisRepository personMybatisRepository;

    @Override
    public void createPerson(CreatePersonRequestDto createPersonRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Person person = modelMapper.map(createPersonRequestDto, Person.class);
        personMybatisRepository.save(person);
    }

    @Override
    public FindPersonResponseDto findPersonById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Person person = personMybatisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        return modelMapper.map(person, FindPersonResponseDto.class);
    }

    @Override
    public void updatePerson(Long id, UpdatePersonRequestDto updatePersonRequestDto) {
        Person person = personMybatisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());

        person.update(updatePersonRequestDto);
        personMybatisRepository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        Person person = personMybatisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        personMybatisRepository.delete(person);
    }
}
