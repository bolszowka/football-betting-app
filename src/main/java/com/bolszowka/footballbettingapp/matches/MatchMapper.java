package com.bolszowka.footballbettingapp.matches;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface MatchMapper {

    Match toEntity(CreateMatchDto dto);

    MatchDto toDto(Match entity);
}
