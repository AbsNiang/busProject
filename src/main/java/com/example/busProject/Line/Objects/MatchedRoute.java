package com.example.busProject.Line.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Originator",
    "OriginationName",
    "Destination",
    "DestinationName",
    "Direction",
    "Name",
    "RouteCode",
    "Operators"
})

public class MatchedRoute {

    @JsonProperty("Originator")
    private String originator;
    @JsonProperty("OriginationName")
    private String originationName;
    @JsonProperty("Destination")
    private String destination;
    @JsonProperty("DestinationName")
    private String destinationName;
    @JsonProperty("Direction")
    private String direction;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("RouteCode")
    private String routeCode;
    @JsonProperty("Operators")
    private Operators__1 operators;

    @JsonProperty("Originator")
    public String getOriginator() {
        return originator;
    }

    @JsonProperty("Originator")
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @JsonProperty("OriginationName")
    public String getOriginationName() {
        return originationName;
    }

    @JsonProperty("OriginationName")
    public void setOriginationName(String originationName) {
        this.originationName = originationName;
    }

    @JsonProperty("Destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("Destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("DestinationName")
    public String getDestinationName() {
        return destinationName;
    }

    @JsonProperty("DestinationName")
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @JsonProperty("Direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("Direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("RouteCode")
    public String getRouteCode() {
        return routeCode;
    }

    @JsonProperty("RouteCode")
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    @JsonProperty("Operators")
    public Operators__1 getOperators() {
        return operators;
    }

    @JsonProperty("Operators")
    public void setOperators(Operators__1 operators) {
        this.operators = operators;
    }

}
