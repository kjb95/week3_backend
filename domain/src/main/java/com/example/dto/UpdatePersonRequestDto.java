package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatePersonRequestDto {
    private String name;
    private Integer age;
}
