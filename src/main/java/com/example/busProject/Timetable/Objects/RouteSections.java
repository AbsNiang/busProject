package com.example.busProject.Timetable.Objects;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MatchedRoute"
})

public class RouteSections {

    @JsonProperty("MatchedRoute")
    private List<MatchedRoute> matchedRoute;

    @JsonProperty("MatchedRoute")
    public List<MatchedRoute> getMatchedRoute() {
        return matchedRoute;
    }

    @JsonProperty("MatchedRoute")
    public void setMatchedRoute(List<MatchedRoute> matchedRoute) {
        this.matchedRoute = matchedRoute;
    }

}
