package com.example.busProject.StopPoint.Objects.StopPointObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Operator"
})
public class Operators {

    @JsonProperty("Operator")
    private List<Operator> operator;

    @JsonProperty("Operator")
    public List<Operator> getOperator() {
        return operator;
    }

    @JsonProperty("Operator")
    public void setOperator(List<Operator> operator) {
        this.operator = operator;
    }
}
