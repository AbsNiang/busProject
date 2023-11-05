package com.example.busProject.StopPoint.Objects;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;


/*
 * timeToLive in the JSON represents how long the data is valid for
 * timeToStation is how long until it gets to the station (in seconds)
 * */
@Getter
@Setter
public class StopPointConnectionDetails {
    private ZonedDateTime timeToLive;
    private int timeToStation; // seconds left until it reaches the stop
    private ZonedDateTime expectedArrivalTime;
    private ZonedDateTime scheduledArrivalTime;
    private String towards; //towards which final destination stop e.g. Leamington, Coventry etc

    public StopPointConnectionDetails(ZonedDateTime timeToLive, int timeToStation, ZonedDateTime expectedArrivalTime, ZonedDateTime scheduledArrivalTime, String towards) {
        this.timeToLive = timeToLive;
        this.timeToStation = timeToStation;
        this.expectedArrivalTime = expectedArrivalTime;
        this.scheduledArrivalTime = scheduledArrivalTime;
        this.towards = towards;
    }

}

