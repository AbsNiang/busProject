package com.example.busProject;

import com.example.busProject.Line.LineService;
import com.example.busProject.StopPoint.StopPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final StopPointService stopPointService;
    private final LineService lineService;

    @GetMapping("/")
    public String home() {
        return "index"; //returns the next view to display.
    }

    @GetMapping("/timetable")
    public String timetableHome(@RequestParam(name = "busStop", required = false,
            defaultValue = "University Interchange") String busStop, Model model) {
        model.addAttribute("busStop", busStop);
        return "timetable"; //returns the next view to display.
    }

    @GetMapping("/stop-point")
    public String stopPointHomePage(){
        return "stop-point-index"; // index page for stop-point
    }
}
