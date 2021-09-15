package com.example.footballbettingapp.matches;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDto {

    Long id;
    String homeTeam;
    String awayTeam;
    String score;
}
