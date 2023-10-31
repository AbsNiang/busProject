package com.example.busProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

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
}
