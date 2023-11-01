package com.example.busProject.Line;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/line")
@RequiredArgsConstructor
public class LineController {
    private final LineService lineService;
    @RequestMapping("/routes")
    public ResponseEntity<String> getLineRoutes() { // uses TFWM
        return ResponseEntity.ok(lineService.getLineRouteData());
    }
}
