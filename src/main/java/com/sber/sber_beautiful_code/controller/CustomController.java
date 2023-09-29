package com.sber.sber_beautiful_code.controller;

import com.sber.sber_beautiful_code.dto.MessageDto;
import com.sber.sber_beautiful_code.service.CustomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomController {

    private final CustomService service;

    @GetMapping("/checkBrackets")
    public ResponseEntity<Object> checkBrackets(@Valid @RequestBody MessageDto messageDto) {
        boolean result = service.checkBrackets(messageDto);
        return ResponseEntity.ok(Map.of("isCorrect", result));
    }
}
