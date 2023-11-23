package org.example.main;

import org.example.model.Championship;
import org.example.model.Match;
import org.example.model.Team;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Team team1 = new Team("Sparta");
        Team team2 = new Team("Slavie");
        Team team3 = new Team("Pardubice");

        List<Team> teams= new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);

        List<Match> matches = new ArrayList<>();
        Championship championship = new Championship(teams,matches);






        championship.startChampionship();
        int teamSize = teams.size();
        System.out.println("Pocet tymu: " + teamSize);
        Team winTeam = championship.getWinTeam();
        System.out.println("Vitezny team je: "+ winTeam.getName());


    }
}