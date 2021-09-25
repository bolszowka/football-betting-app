package com.bolszowka.footballbettingapp.matches;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateMatchDto {

    String homeTeam;
    String awayTeam;
}
