package com.example.busProject.StopPoint.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopPoint"
})
public class Example {

    @JsonProperty("StopPoint")
    private StopPoint stopPoint;

    @JsonProperty("StopPoint")
    public StopPoint getStopPoint() {
        return stopPoint;
    }

    @JsonProperty("StopPoint")
    public void setStopPoint(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
    }
}