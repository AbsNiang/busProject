package com.example.busProject.StopPoint.Objects.LineObject;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Prediction"
})
public class ArrayOfPrediction {

    @JsonProperty("Prediction")
    private List<Prediction> prediction;

    @JsonProperty("Prediction")
    public List<Prediction> getPrediction() {
        return prediction;
    }

    @JsonProperty("Prediction")
    public void setPrediction(List<Prediction> prediction) {
        this.prediction = prediction;
    }

}