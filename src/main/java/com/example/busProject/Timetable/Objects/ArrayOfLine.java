
package com.example.busProject.Timetable.Objects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Line"
})

public class ArrayOfLine {

    @JsonProperty("Line")
    private List<Line> line;

    @JsonProperty("Line")
    public List<Line> getLine() {
        return line;
    }

    @JsonProperty("Line")
    public void setLine(List<Line> line) {
        this.line = line;
    }

}
