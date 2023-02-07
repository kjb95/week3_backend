package com.example.service.jpa;

import com.example.domain.jpa.PersonEntity;
import com.example.dto.CreatePersonRequestDto;
import com.example.dto.FindPersonResponseDto;
import com.example.dto.UpdatePersonRequestDto;
import com.example.repository.jpa.PersonJpaRepository;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PersonJpaService implements PersonService {
    private final PersonJpaRepository personJpaRepository;

    @Override
    public void createPerson(CreatePersonRequestDto createPersonRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        PersonEntity person = modelMapper.map(createPersonRequestDto, PersonEntity.class);
        personJpaRepository.save(person);
    }

    @Override
    public FindPersonResponseDto findPersonById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        PersonEntity person = personJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        return modelMapper.map(person, FindPersonResponseDto.class);
    }

    @Override
    public void updatePerson(Long id, UpdatePersonRequestDto updatePersonRequestDto) {
        PersonEntity person = personJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        person.update(updatePersonRequestDto);
        personJpaRepository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        PersonEntity person = personJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
        personJpaRepository.delete(person);
    }
}
