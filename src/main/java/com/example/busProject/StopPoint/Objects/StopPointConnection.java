package com.example.busProject.StopPoint.Objects;

public class StopPointConnection {
    private String originId;
    private String destinationId;
    private String routeId;

    public StopPointConnection(String originId, String destinationId, String routeId) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.routeId = routeId;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
