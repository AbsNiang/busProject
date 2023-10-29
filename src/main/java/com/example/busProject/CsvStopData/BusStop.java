package com.example.busProject.CsvStopData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String atcoCode;
    private String naptanCode;
    private String plateCode;
    private String commonName;
    private String shortCommonName;
    private String landmark; //e.g. rail station
    private String street;
    private String indicator;
    private String bearing;
    private String nptgLocalityCode;
    private String LocalityName;
    private String parentLocalityName; //most useful prolly, e.g. Bristol
    private String town;
    private String suburb;
    private String localityCentre;
    private int easting;
    private int northing;
    private double longitude;
    private double latitude;
    private String stopType;
    private String busStopType;
    private String timingStatus;
    private String adminAreaCode;
    private String status; //only want active, delete inactive.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtcoCode() {
        return atcoCode;
    }

    public void setAtcoCode(String atcoCode) {
        this.atcoCode = atcoCode;
    }

    public String getNaptanCode() {
        return naptanCode;
    }

    public void setNaptanCode(String naptanCode) {
        this.naptanCode = naptanCode;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getShortCommonName() {
        return shortCommonName;
    }

    public void setShortCommonName(String shortCommonName) {
        this.shortCommonName = shortCommonName;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getNptgLocalityCode() {
        return nptgLocalityCode;
    }

    public void setNptgLocalityCode(String nptgLocalityCode) {
        this.nptgLocalityCode = nptgLocalityCode;
    }

    public String getLocalityName() {
        return LocalityName;
    }

    public void setLocalityName(String localityName) {
        LocalityName = localityName;
    }

    public String getParentLocalityName() {
        return parentLocalityName;
    }

    public void setParentLocalityName(String parentLocalityName) {
        this.parentLocalityName = parentLocalityName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getLocalityCentre() {
        return localityCentre;
    }

    public void setLocalityCentre(String localityCentre) {
        this.localityCentre = localityCentre;
    }

    public int getEasting() {
        return easting;
    }

    public void setEasting(int easting) {
        this.easting = easting;
    }

    public int getNorthing() {
        return northing;
    }

    public void setNorthing(int northing) {
        this.northing = northing;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    public String getBusStopType() {
        return busStopType;
    }

    public void setBusStopType(String busStopType) {
        this.busStopType = busStopType;
    }

    public String getTimingStatus() {
        return timingStatus;
    }

    public void setTimingStatus(String timingStatus) {
        this.timingStatus = timingStatus;
    }

    public String getAdminAreaCode() {
        return adminAreaCode;
    }

    public void setAdminAreaCode(String adminAreaCode) {
        this.adminAreaCode = adminAreaCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
