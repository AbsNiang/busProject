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
public class TimetableResult {
    private int id;
    private String created;
    private String modified;
    private String operatorName;
    private List<String> noc;
    private String name;
    private String description;
    private String comment;
    private String status;
    private String url;//contains download file for the actual data
    private String extension;
    private List<String> lines;
    private String firstStartDate;
    private String firstEndDate;
    private String lastEndDate;
    private List<AdminArea> adminAreas;
    private List<Locality> localities;
    private String dqScore;
    private String dqRag;
    private boolean bodsCompliance;

}
