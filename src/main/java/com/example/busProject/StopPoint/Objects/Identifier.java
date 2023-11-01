package com.example.busProject.StopPoint.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "Type",
        "Uri",
        "Operators"
})
public class Identifier {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Uri")
    private String uri;
    @JsonProperty("Operators")
    private Operators operators;

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

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
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

}