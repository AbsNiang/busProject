package com.example.busProject.Timetable.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor initializing all fields
@Getter // Generates getters
@Setter// Generates setters
public class TimetableData {
    private int count;
    private String next;
    private String previous;
    private List<TimetableResult> results;
}

