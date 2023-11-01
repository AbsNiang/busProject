package com.example.busProject.StopPoint.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Identifier"
})
public class Lines {

    @JsonProperty("Identifier")
    private List<Identifier> identifier;

    @JsonProperty("Identifier")
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    @JsonProperty("Identifier")
    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

}