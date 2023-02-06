package com.example.domain.jpa;


import com.example.dto.UpdatePersonRequestDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "person")
@RequiredArgsConstructor
@Data
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    public void update(UpdatePersonRequestDto updatePersonRequestDto) {
        name = updatePersonRequestDto.getName() == null ? name : updatePersonRequestDto.getName();
        age = updatePersonRequestDto.getAge() == null ? age : updatePersonRequestDto.getAge();
    }
}
