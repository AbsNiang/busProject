package com.example.busProject.Timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    //need to edit
    private final TimetableService timetableService;

    @GetMapping("/data")
    public ResponseEntity<?> callBODsToGetTimetableData() {
        return ResponseEntity.ok(timetableService.getAllTimetables());
    }
}
