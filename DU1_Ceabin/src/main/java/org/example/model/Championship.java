package org.example.model;


import java.util.List;
import java.util.Random;

public class Championship {
    private List<Team> teams;
    private List<Match> matches;

    public Championship(List<Team> teams, List<Match> matches) {
        this.teams = teams;
        this.matches = matches;
    }


    public void generateMatch(){
        if (teams.size()<2)
        {
            throw new IllegalStateException("Malo teamu v sampionatu");
        }
        matches.clear();

        for (int i = 0; i < teams.size() - 1; i++)
        {
            for(int j = i+1; j < teams.size(); j++){
                Match match = new Match(teams.get(i), teams.get(j));
                matches.add(match);
            }
        }

    }

    public void simulateMatches() {
        for (Match match : matches) {
            match.startMatch();
            Random random = new Random();
            int teamAgoals = random.nextInt(5);
            int teamBgoals = random.nextInt(5);
            Team teamA = match.getTeamA();
            Team teamB = match.getTeamB();

            for (int i = 0; i < teamAgoals; i++) {
                match.addGoal(teamA, random.nextInt(90));
            }
            for (int i = 0; i < teamBgoals; i++) {
                match.addGoal(teamB, random.nextInt(90));
            }

            // Pridani zlute karty s pravdepodobnosti 30%
            if (random.nextDouble() < 0.3) {
                match.addYellowCard(teamA, random.nextInt(90));
            }
            if (random.nextDouble() < 0.3) {
                match.addYellowCard(teamB, random.nextInt(90));
            }

            // Pridani penalty s pravdepodobnosti 20%
            if (random.nextDouble() < 0.2) {
                match.addPenalty(teamA, random.nextInt(90));
            }
            if (random.nextDouble() < 0.2) {
                match.addPenalty(teamB, random.nextInt(90));
            }
            match.endMatch();
            match.printMatchLog();
            System.out.println();
        }
    }




    public Team getWinTeam() {
        if (matches.isEmpty()) {
            throw new IllegalStateException("Žádný šampionát se nekonal");
        }

        Team winTeam = null;
        int maxScore = -1;
        boolean draw = false;

        for (Match match : matches) {
            int scoreA = match.getTeamAscore();
            int scoreB = match.getTeamBscore();

            if (scoreA > maxScore) {
                maxScore = scoreA;
                winTeam = match.getTeamA();
                draw = false;
            } else if (scoreA == maxScore) {
                draw = true;
            }

            if (scoreB > maxScore) {
                maxScore = scoreB;
                winTeam = match.getTeamB();
                draw = false;
            } else if (scoreB == maxScore) {
                draw = true;
            }
        }

        if (draw) {
            System.out.println("Remíza");
        }

        return winTeam;
    }

    public void startChampionship()
    {
        generateMatch();
        simulateMatches();
    }
}
