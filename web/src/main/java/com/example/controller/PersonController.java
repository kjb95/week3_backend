package com.example.controller;

import com.example.dto.CreatePersonRequestDto;
import com.example.dto.FindPersonResponseDto;
import com.example.dto.UpdatePersonRequestDto;
import com.example.service.mybatis.PersonMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {
    //    private final PersonJpaService personService;
    private final PersonMybatisService personService;

    @PostMapping("/")
    public ResponseEntity<Void> createPerson(@RequestBody @Validated CreatePersonRequestDto createPersonRequestDto) {
        personService.createPerson(createPersonRequestDto);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindPersonResponseDto> findPersonById(@PathVariable Long id) {
        FindPersonResponseDto findPersonResponseDto = personService.findPersonById(id);
        return ResponseEntity.ok()
                .body(findPersonResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody @Validated UpdatePersonRequestDto updatePersonRequestDto) {
        personService.updatePerson(id, updatePersonRequestDto);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok()
                .build();
    }
}
