package org.model;
import org.example.model.Match;
import org.example.model.Team;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;




public class MatchTest {

    private Team teamA;
    private Team teamB;
    private Match match;

    public void setUp() {
        teamA = new Team("Team A");
        teamB = new Team("Team B");
        match = new Match(teamA, teamB);
    }
    // Overeni skore
    public void testMatchScore() {

        match.addGoal(teamA, 30);
        match.addGoal(teamB, 45);
        match.addGoal(teamA, 55);

        assertEquals(2, match.getTeamAscore());
        assertEquals(1, match.getTeamBscore());
    }



}