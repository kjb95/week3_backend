package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CreatePersonRequestDto {
    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private Integer age;
}
