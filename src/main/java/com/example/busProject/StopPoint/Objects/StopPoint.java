package com.example.busProject.StopPoint.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Lat",
        "Lon",
        "Indicator",
        "StopLetter",
        "Children",
        "CommonName",
        "Locality",
        "Id",
        "PlaceType",
        "Lines",
        "Modes",
        "NaptanId",
        "StationNaptan",
        "StopType"
})
public class StopPoint {
    @JsonProperty("Lat")
    private Double lat;
    @JsonProperty("Lon")
    private Double lon;
    @JsonProperty("Indicator")
    private String indicator;
    @JsonProperty("StopLetter")
    private String stopLetter;
    @JsonProperty("Children")
    private Children children;
    @JsonProperty("CommonName")
    private String commonName;
    @JsonProperty("Locality")
    private String locality;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("PlaceType")
    private String placeType;
    @JsonProperty("Lines")
    private Lines lines;
    @JsonProperty("Modes")
    private Modes modes;
    @JsonProperty("NaptanId")
    private String naptanId;
    @JsonProperty("StationNaptan")
    private String stationNaptan;
    @JsonProperty("StopType")
    private String stopType;

    @JsonProperty("Lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("Lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("Lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("Lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @JsonProperty("Indicator")
    public String getIndicator() {
        return indicator;
    }

    @JsonProperty("Indicator")
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @JsonProperty("StopLetter")
    public String getStopLetter() {
        return stopLetter;
    }

    @JsonProperty("StopLetter")
    public void setStopLetter(String stopLetter) {
        this.stopLetter = stopLetter;
    }

    @JsonProperty("Children")
    public Children getChildren() {
        return children;
    }

    @JsonProperty("Children")
    public void setChildren(Children children) {
        this.children = children;
    }

    @JsonProperty("CommonName")
    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("CommonName")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("Locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("Locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("PlaceType")
    public String getPlaceType() {
        return placeType;
    }

    @JsonProperty("PlaceType")
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    @JsonProperty("Lines")
    public Lines getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(Lines lines) {
        this.lines = lines;
    }

    @JsonProperty("Modes")
    public Modes getModes() {
        return modes;
    }

    @JsonProperty("Modes")
    public void setModes(Modes modes) {
        this.modes = modes;
    }

    @JsonProperty("NaptanId")
    public String getNaptanId() {
        return naptanId;
    }

    @JsonProperty("NaptanId")
    public void setNaptanId(String naptanId) {
        this.naptanId = naptanId;
    }

    @JsonProperty("StationNaptan")
    public String getStationNaptan() {
        return stationNaptan;
    }

    @JsonProperty("StationNaptan")
    public void setStationNaptan(String stationNaptan) {
        this.stationNaptan = stationNaptan;
    }

    @JsonProperty("StopType")
    public String getStopType() {
        return stopType;
    }

    @JsonProperty("StopType")
    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

}
