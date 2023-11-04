package com.example.busProject.StopPoint;

import com.example.busProject.Line.LineService;
import com.example.busProject.Line.Objects.ArrayOfLine;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stop-point")
@RequiredArgsConstructor
public class StopPointController {
    private final StopPointService stopPointService;
    private final LineService lineService;

    //can call other GETs in a different controller to get the data
    @RequestMapping("/search")
    public ResponseEntity<String> getStopPointsBySearch() {
        //return ResponseEntity.ok(lineController.getLineRoutes().toString());
        return ResponseEntity.ok(stopPointService.test());
    }

    @RequestMapping("/uwu")
    public ResponseEntity<String> receiveData() {
        ArrayOfLine arrayOfLine = lineService.sendDataToAnotherController();

//        String destinationStopPointIds =
//                stopPointService.searchForStop(arrayOfLine, General.getInput("What stop are you going to"));
        // ** instead of returning the ids as [1,2], concatenate in correct format with %2C already - searchForStop
        // */ parse those to a method which gets stop-pointData for each id - getStopPointDataFromIDs
        // parse that data to objects
        // for each stop point check the lines and check if that line goes to the destination
        //return the stop points and lines which can be joined
        //eventually, if none, get a bounding box with increasing area until a stop-point is found.
        //eventually, get ip of user with API and use a geolocation API to get a  bounding box for an area search
        return ResponseEntity.ok(stopPointService.doAll(arrayOfLine, "university of warwick", "coventry rail station"));
    }

}
