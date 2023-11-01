package com.example.busProject.Timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @RequestMapping("/dataset")
    public ResponseEntity<?> getTimetableDatasets() { // uses BODS
        return ResponseEntity.ok(timetableService.getAllTimetables());
    }

    //move this to a separate controller after


}

//University Interchange lat = 52.37946319580078, long = -1.5626189708709717