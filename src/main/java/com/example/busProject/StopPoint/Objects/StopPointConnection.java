package com.example.busProject.StopPoint.Objects;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

public class StopPointConnection {
    private String originId;
    private String originName;
    private String destinationId;
    private String destinationName;
    private String lineName;
    private String lineId;

    public StopPointConnection(String originName, String originId,
                               String destinationName, String destinationId,
                               String lineName, String lineId) {
        this.originName = originName;
        this.originId = originId;
        this.destinationName = destinationName;
        this.destinationId = destinationId;
        this.lineName = lineName;
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    @Override
    public String toString(){
        return "Origin ID: " + this.originId
                + ", Origin Name: " + this.originName
                + ", Destination ID: " + this.destinationId
                + ", Destination Name: " + this.destinationName
                + ", Line Name: " + this.lineName
                + ", Line ID: " + this.lineId;
    }
}