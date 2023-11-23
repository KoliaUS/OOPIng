package org.example.model;

import java.time.ZonedDateTime;
enum eventType {
    START,GOAL,END,PENALTY, YellowCard
}

public class Event {
    private eventType eventType;
    private ZonedDateTime time;
    private int gameMinute;
    private Team team;

    public Event(eventType eventType, ZonedDateTime time, int gameMinute, Team team) {
        this.eventType = eventType;
        this.time = time;
        this.gameMinute = gameMinute;
        this.team = team;
    }

    public eventType getEventType() {
        return eventType;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public int getGameMinute() {
        return gameMinute;
    }

    public Team getTeam() {
        return team;
    }
}
