package com.example.busProject.Timetable.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor initializing all fields
@Getter // Generates getters
@Setter// Generates setters
public class AdminArea {
    private String atco_code;
    private String name;

}
