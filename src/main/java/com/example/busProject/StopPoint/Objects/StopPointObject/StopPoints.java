package com.example.busProject.StopPoint.Objects.StopPointObject;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopPoint"
})
public class StopPoints {

    @JsonProperty("StopPoint")
    private List<StopPoint> stopPoint;

    @JsonProperty("StopPoint")
    public List<StopPoint> getStopPoint() {
        return stopPoint;
    }

    @JsonProperty("StopPoint")
    public void setStopPoint(List<StopPoint> stopPoint) {
        this.stopPoint = stopPoint;
    }

}