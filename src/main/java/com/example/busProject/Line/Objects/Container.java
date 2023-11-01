package com.example.busProject.Line.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ArrayOfLine"
})

public class Container {

    @JsonProperty("ArrayOfLine")
    private ArrayOfLine arrayOfLine;

    @JsonProperty("ArrayOfLine")
    public ArrayOfLine getArrayOfLine() {
        return arrayOfLine;
    }

    @JsonProperty("ArrayOfLine")
    public void setArrayOfLine(ArrayOfLine arrayOfLine) {
        this.arrayOfLine = arrayOfLine;
    }

}
