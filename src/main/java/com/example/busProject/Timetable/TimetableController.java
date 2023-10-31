package com.example.busProject.Timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    //need to edit
    private final TimetableService timetableService;

    @RequestMapping("/dataset")
    public ResponseEntity<?> getTimetableDatasets() { // uses BODS
        return ResponseEntity.ok(timetableService.getAllTimetables());
    }

//        @RequestMapping("/line-routes")
//    public ResponseEntity<?> getLineRoutes() { // uses TFWM
//        return ResponseEntity.ok(timetableService.getLineRoutes());
//    }
    @RequestMapping("/line-routes")
    public ResponseEntity<String> getLineRoutes() { // uses TFWM
        return ResponseEntity.ok(timetableService.test());
    }
}
