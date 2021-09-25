package com.bolszowka.footballbettingapp.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MatchRepository extends JpaRepository<Match, Long> {

}