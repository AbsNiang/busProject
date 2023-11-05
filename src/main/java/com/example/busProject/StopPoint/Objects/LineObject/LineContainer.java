package com.example.busProject.StopPoint.Objects.LineObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ArrayOfPrediction"
})
public class LineContainer {

    @JsonProperty("ArrayOfPrediction")
    private ArrayOfPrediction arrayOfPrediction;

    @JsonProperty("ArrayOfPrediction")
    public ArrayOfPrediction getArrayOfPrediction() {
        return arrayOfPrediction;
    }

    @JsonProperty("ArrayOfPrediction")
    public void setArrayOfPrediction(ArrayOfPrediction arrayOfPrediction) {
        this.arrayOfPrediction = arrayOfPrediction;
    }

}