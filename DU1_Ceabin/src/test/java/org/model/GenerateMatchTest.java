package org.model;

import org.example.model.Championship;
import org.example.model.Match;
import org.example.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateMatchTest {

    private Championship championship;

    @BeforeEach
    public void setUp() {
        List<Team> teams = new ArrayList<>();
        championship = new Championship(teams, new ArrayList<>());
    }

    @Test
    void generateMatch_TeamsEmpty_throwIllegalStateException() {
        assertThrows(IllegalStateException.class, championship::generateMatch);
    }

    @Test
    void generateMatch_OneTeam_throwIllegalStateException() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Team 1"));
        championship = new Championship(teams, new ArrayList<>());

        assertThrows(IllegalStateException.class, championship::generateMatch);
    }


}
