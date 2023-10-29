package com.example.busProject.Location;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    //need to edit
    private final LocationService locationService;

    @GetMapping("/get-overall-data")
    public ResponseEntity<?> callBODsToGetLocationData() {
        return ResponseEntity.ok(locationService.getOverallLocationData());
    }
}
