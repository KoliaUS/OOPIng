package org.example.model;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Match {
    private Team teamA;
    private Team teamB;
    private List<Event> events;
    private eventType start;
    private eventType end;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.events = new ArrayList<>();
        this.start = null;
        this.end = null;
    }



    public void startMatch() {
        if (start != null) {
            throw new IllegalStateException("Zapas uz byl zahajen");
        }
        start = eventType.START;

    }

    public void endMatch() {
        if (start==null) {
            throw new IllegalStateException("Zapas jeste nebyl zahajen");
        }
        if (end != null) {
            throw new IllegalStateException("Zapas uz byl ukoncen");
        }
        end = eventType.END;

    }

    public Team getTeamA()
    {
        return teamA;
    }

    public Team getTeamB()
    {
        return teamB;
    }
    public int getTeamAscore()
    {
        int teamAscore = 0;
        for (Event event: events){
            if (event.getEventType() == eventType.GOAL && event.getTeam() == teamA)
            {
             teamAscore++;
            }
        }
        return teamAscore;
    }

    public int getTeamBscore()
    {
        int teamBscore = 0;
        for (Event event: events)
        {
            if (event.getEventType() == eventType.GOAL && event.getTeam() == teamB)
            {
                teamBscore++;
            }
        }
        return teamBscore;

    }

    public void addGoal(Team team, int gameMinute)
    {
        if (start!= eventType.START) {
            throw new IllegalStateException("Zapas nezacal");
        }
        if (end == eventType.END) {
            throw new IllegalStateException("Zapas jiz byl ukoncen");
        }
        events.add(new Event(eventType.GOAL, ZonedDateTime.now(), gameMinute, team));

    }

    public List<Event> getEventsInOrder() {
        List<Event> eventsC = new ArrayList<>(events);
        eventsC.sort(Comparator.comparing(Event::getTime));
        return eventsC;
    }

    public void printMatchLog(){
        System.out.println("Zacatek zapasu: " + this.getTeamA().getName() + " vs " + this.getTeamB().getName());
        List<Event> eventsInOrder = this.getEventsInOrder();
        Collections.sort(eventsInOrder, Comparator.comparingInt(Event::getGameMinute));

        for (Event event : eventsInOrder) {
            switch (event.getEventType()) {
                case START:
                    System.out.println("Zacatek zapasu: " + event.getTeam().getName());
                    break;
                case GOAL:
                    System.out.println("Gol pridan: " + event.getTeam().getName() + ", Minuta: " + event.getGameMinute());
                    break;
                case END:
                    System.out.println("Konec zapasu: " + event.getTeam().getName());
                    break;
                case YellowCard:
                    System.out.println("Zluta karta udelena: " + event.getTeam().getName() + ", Minuta: " + event.getGameMinute());
                    break;
                case PENALTY:
                    System.out.println("Penalta udelena: " + event.getTeam().getName() + ", Minuta: " + event.getGameMinute());
                    break;
                default:
                    break;
            }
        }
        System.out.println();
    }



    public void addYellowCard(Team team, int gameMinute)
    {
        if (start != eventType.START)
        {
            throw new IllegalStateException("Zapas jeste nezacal");
        }
        if (end == eventType.END)
        {
            throw new IllegalStateException("Zapas jiz skoncil");
        }
        events.add(new Event(eventType.YellowCard, ZonedDateTime.now(), gameMinute, team));
    }

    public void addPenalty(Team team, int gameMinute)
    {
        if(start != eventType.START)
        {
            throw new IllegalStateException("Zapas jeste nezacal");
        }
        if (end==eventType.END)
        {
            throw new IllegalStateException("Zapas jiz skoncil");
        }
        events.add(new Event(eventType.PENALTY,ZonedDateTime.now(),gameMinute,team));
    }



}




