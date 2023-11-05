package com.example.busProject.StopPoint.Objects.LineObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DestinationName",
        "DestinationNaptanId",
        "Direction",
        "ExpectedArrival",
        "ScheduledArrival",
        "Id",
        "LineId",
        "LineName",
        "ModeName",
        "StopSequence",
        "NaptanId",
        "PlatformName",
        "StationName",
        "TimeToLive",
        "TimeToStation",
        "Timestamp",
        "Towards",
        "VehicleId",
        "Operator"
})
public class Prediction {

    @JsonProperty("DestinationName")
    private String destinationName;
    @JsonProperty("DestinationNaptanId")
    private String destinationNaptanId;
    @JsonProperty("Direction")
    private String direction;
    @JsonProperty("ExpectedArrival")
    private String expectedArrival;
    @JsonProperty("ScheduledArrival")
    private String scheduledArrival;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("LineId")
    private String lineId;
    @JsonProperty("LineName")
    private String lineName;
    @JsonProperty("ModeName")
    private String modeName;
    @JsonProperty("StopSequence")
    private String stopSequence;
    @JsonProperty("NaptanId")
    private String naptanId;
    @JsonProperty("PlatformName")
    private String platformName;
    @JsonProperty("StationName")
    private String stationName;
    @JsonProperty("TimeToLive")
    private String timeToLive;
    @JsonProperty("TimeToStation")
    private String timeToStation;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("Towards")
    private String towards;
    @JsonProperty("VehicleId")
    private String vehicleId;
    @JsonProperty("Operator")
    private Operator operator;

    @JsonProperty("DestinationName")
    public String getDestinationName() {
        return destinationName;
    }

    @JsonProperty("DestinationName")
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @JsonProperty("DestinationNaptanId")
    public String getDestinationNaptanId() {
        return destinationNaptanId;
    }

    @JsonProperty("DestinationNaptanId")
    public void setDestinationNaptanId(String destinationNaptanId) {
        this.destinationNaptanId = destinationNaptanId;
    }

    @JsonProperty("Direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("Direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("ExpectedArrival")
    public String getExpectedArrival() {
        return expectedArrival;
    }

    @JsonProperty("ExpectedArrival")
    public void setExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    @JsonProperty("ScheduledArrival")
    public String getScheduledArrival() {
        return scheduledArrival;
    }

    @JsonProperty("ScheduledArrival")
    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("LineId")
    public String getLineId() {
        return lineId;
    }

    @JsonProperty("LineId")
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    @JsonProperty("LineName")
    public String getLineName() {
        return lineName;
    }

    @JsonProperty("LineName")
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @JsonProperty("ModeName")
    public String getModeName() {
        return modeName;
    }

    @JsonProperty("ModeName")
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    @JsonProperty("StopSequence")
    public String getStopSequence() {
        return stopSequence;
    }

    @JsonProperty("StopSequence")
    public void setStopSequence(String stopSequence) {
        this.stopSequence = stopSequence;
    }

    @JsonProperty("NaptanId")
    public String getNaptanId() {
        return naptanId;
    }

    @JsonProperty("NaptanId")
    public void setNaptanId(String naptanId) {
        this.naptanId = naptanId;
    }

    @JsonProperty("PlatformName")
    public String getPlatformName() {
        return platformName;
    }

    @JsonProperty("PlatformName")
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @JsonProperty("StationName")
    public String getStationName() {
        return stationName;
    }

    @JsonProperty("StationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("TimeToLive")
    public String getTimeToLive() {
        return timeToLive;
    }

    @JsonProperty("TimeToLive")
    public void setTimeToLive(String timeToLive) {
        this.timeToLive = timeToLive;
    }

    @JsonProperty("TimeToStation")
    public String getTimeToStation() {
        return timeToStation;
    }

    @JsonProperty("TimeToStation")
    public void setTimeToStation(String timeToStation) {
        this.timeToStation = timeToStation;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("Timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("Towards")
    public String getTowards() {
        return towards;
    }

    @JsonProperty("Towards")
    public void setTowards(String towards) {
        this.towards = towards;
    }

    @JsonProperty("VehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    @JsonProperty("VehicleId")
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @JsonProperty("Operator")
    public Operator getOperator() {
        return operator;
    }

    @JsonProperty("Operator")
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

}