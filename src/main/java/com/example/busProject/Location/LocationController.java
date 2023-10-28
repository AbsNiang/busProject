package com.example.busProject.Location;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/datafeed")
@RequiredArgsConstructor
public class LocationController {
    //need to edit
    private final LocationService locationService;

    @GetMapping("/get-bus-timetable-data")
    public ResponseEntity<?> callBODsToGetTimetableData(){
    return (ResponseEntity<?>) ResponseEntity.ok();
    }
}
