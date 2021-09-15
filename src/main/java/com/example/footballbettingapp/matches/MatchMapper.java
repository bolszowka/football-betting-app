package com.example.footballbettingapp.matches;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    Match toEntity(CreateMatchDto dto);

    MatchDto toDto(Match entity);
}
