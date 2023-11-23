package org.model;

import org.example.model.Championship;
import org.example.model.Team;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChampionshipTest {

    @Test
    public void testChampionshipWinner() {

        Team team1 = new Team("Team A");
        Team team2 = new Team("Team B");
        Team team3 = new Team("Team C");


        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);


        Championship championship = new Championship(teams, new ArrayList<>());


        championship.startChampionship();


        Team winner = championship.getWinTeam();

        // Overeni ze winner neni null
        assertNotNull(winner);
    }
}
