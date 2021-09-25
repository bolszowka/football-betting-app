package com.bolszowka.footballbettingapp.matches;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/match")
    public Long createMatch(@RequestBody CreateMatchDto dto) {
        return service.createMatch(dto);
    }

    @GetMapping("/match/{id}")
    public MatchDto getMatchDetails(@PathVariable Long id) {
        return service.getMatchDetails(id);
    }
}
