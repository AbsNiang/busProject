package com.example.busProject.StopPoint.Objects.StopPointObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopPoints"
})
public class StopPointContainer {

    @JsonProperty("StopPoints")
    private StopPoints stopPoints;

    @JsonProperty("StopPoints")
    public StopPoints getStopPoint() {
        return stopPoints;
    }

    @JsonProperty("StopPoints")
    public void setStopPoint(StopPoints stopPoints) {
        this.stopPoints = stopPoints;
    }
}