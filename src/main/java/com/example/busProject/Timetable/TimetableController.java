package com.example.busProject.Timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final LineService lineService;
    private final StopPointService stopPointService;

    @RequestMapping("/dataset")
    public ResponseEntity<?> getTimetableDatasets() { // uses BODS
        return ResponseEntity.ok(lineService.getAllTimetables());
    }

    //move this to a separate controller after
    @RequestMapping("/stops")
    public ResponseEntity<String> getStopPointsBySearch() {
        return ResponseEntity.ok(stopPointService.test());
    }

    @RequestMapping("/line-routes")
    public ResponseEntity<String> getLineRoutes() { // uses TFWM
        return ResponseEntity.ok(lineService.getLineRouteData());
    }
}
