package com.example.busProject.StopPoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stop-point")
@RequiredArgsConstructor
public class StopPointController {
    private final StopPointService stopPointService;

    @RequestMapping("/search")
    public ResponseEntity<String> getStopPointsBySearch() {
        return ResponseEntity.ok(stopPointService.test());
    }

}
