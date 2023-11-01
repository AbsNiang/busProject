package com.example.busProject.StopPoint.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Mode"
})
public class Modes {
    @JsonProperty("Mode")
    private String mode;

    @JsonProperty("Mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("Mode")
    public void setMode(String mode) {
        this.mode = mode;
    }
}
