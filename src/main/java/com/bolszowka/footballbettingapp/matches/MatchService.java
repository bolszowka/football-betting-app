package com.bolszowka.footballbettingapp.matches;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MatchService {

    private final MatchRepository repository;
    private final MatchMapper mapper;

    public Long createMatch(CreateMatchDto createMatchDto) {
        Match savedMatch = repository.save(mapper.toEntity(createMatchDto));
        return savedMatch.getId();
    }

    public MatchDto getMatchDetails(Long id) {
        return repository.findById(id)
            .map(mapper::toDto)
            .orElseThrow(() -> new EntityNotFoundException("Could not found match with id: " + id));
    }
}
