package com.example.service;

import com.example.dto.CreatePersonRequestDto;
import com.example.dto.FindPersonResponseDto;
import com.example.dto.UpdatePersonRequestDto;

public interface PersonService {
    void createPerson(CreatePersonRequestDto createPersonRequestDto);

    FindPersonResponseDto findPersonById(Long id);

    void updatePerson(Long id, UpdatePersonRequestDto updatePersonRequestDto);

    void deletePersonById(Long id);

}
