package com.example.busProject.StopPoint;

import com.example.busProject.StopPoint.Objects.StopPointObject.StopPoint;

public class BoundingBox {
    private double minLat;
    private double minLon;
    private double maxLat;
    private double maxLon;

    public BoundingBox() {
    }

    //gets a bounding box for a stop point 500m each way from the stop id given, small distance so curvature is negligible
    public void setBoundingBoxForStop(StopPoint stopPoint){
        double meters = 500;
        double degreesLong = meters / (111320 * Math.cos(Math.toRadians(stopPoint.getLat())));
        double degreesLat = meters / 110574; // 1 degree of latitude is about 110.574 km

        this.minLat = stopPoint.getLat() - (degreesLat);
        this.maxLat = stopPoint.getLat() + (degreesLat);
        this.minLon = stopPoint.getLon() - (degreesLong);
        this.maxLon = stopPoint.getLon() + (degreesLong);
    }

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public void setMinLon(double minLon) {
        this.minLon = minLon;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(double maxLon) {
        this.maxLon = maxLon;
    }
}
