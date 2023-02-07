package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class UpdatePersonRequestDto {
    private String name;
    @Min(1)
    private Integer age;
}
