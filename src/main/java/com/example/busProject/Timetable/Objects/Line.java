package com.example.busProject.Timetable.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Name",
    "ModeName",
    "Uri",
    "Operators",
    "RouteSections"
})

public class Line {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ModeName")
    private String modeName;
    @JsonProperty("Uri")
    private String uri;
    @JsonProperty("Operators")
    private Operators operators;
    @JsonProperty("RouteSections")
    private RouteSections routeSections;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ModeName")
    public String getModeName() {
        return modeName;
    }

    @JsonProperty("ModeName")
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    @JsonProperty("Uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("Uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("Operators")
    public Operators getOperators() {
        return operators;
    }

    @JsonProperty("Operators")
    public void setOperators(Operators operators) {
        this.operators = operators;
    }

    @JsonProperty("RouteSections")
    public RouteSections getRouteSections() {
        return routeSections;
    }

    @JsonProperty("RouteSections")
    public void setRouteSections(RouteSections routeSections) {
        this.routeSections = routeSections;
    }

}
