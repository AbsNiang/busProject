package com.example.busProject.Location;

import com.example.busProject.API;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    //boundingBox is a lot more useful, allows us to automate choosing services to look at
    public static void getLocationData() {
        FetchData.getData(API.forLocationData, bbParams(51.401, 51.509, 0.01, 0.201));//National express west midlands
    }

    //sets boundingBox parameters
    private static String bbParams(double minLong, double minLat, double maxLong, double maxLat) {//longitude and latitude
        return "boundingBox=" + minLong + "," + minLat + "," + maxLong + "," + maxLat;
    }
}
