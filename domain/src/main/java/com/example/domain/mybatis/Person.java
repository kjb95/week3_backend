package com.example.domain.mybatis;

import com.example.dto.UpdatePersonRequestDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Person {
    private Long id;

    private String name;

    private Integer age;

    public void update(UpdatePersonRequestDto updatePersonRequestDto) {
        name = updatePersonRequestDto.getName() == null ? name : updatePersonRequestDto.getName();
        age = updatePersonRequestDto.getAge() == null ? age : updatePersonRequestDto.getAge();
    }
}
