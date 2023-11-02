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
        return ResponseEntity.ok(stopPointService.searchForStop(arrayOfLine, "coventry rail station"));
    }

}
