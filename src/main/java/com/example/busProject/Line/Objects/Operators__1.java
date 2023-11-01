
package com.example.busProject.Line.Objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Operator"
})

public class Operators__1 {

    @JsonProperty("Operator")
    private List<Operator__1> operator;

    @JsonProperty("Operator")
    public List<Operator__1> getOperator() {
        return operator;
    }

    @JsonProperty("Operator")
    public void setOperator(List<Operator__1> operator) {
        this.operator = operator;
    }

}
