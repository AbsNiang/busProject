package com.example.busProject.StopPoint.Objects;

public class StopPointConnection {
    private String originId;
    private String destinationId;
    private String lineId;

    public StopPointConnection(String originId, String destinationId, String lineId) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.lineId = lineId;
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

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
}
