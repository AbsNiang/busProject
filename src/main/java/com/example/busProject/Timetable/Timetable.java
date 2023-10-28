package com.example.busProject.Timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor initializing all fields
@Getter // Generates getters
@Setter// Generates setters
public class Timetable {
    private long id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String operatorName;
    private List<String> noc;
    private String name;
    private String description;
    private String comment;
    private String status;
    private String url;
    private String extension;
    private List<String> lines;
    private LocalDateTime firstStartDate;
    private LocalDateTime firstEndDate;
    private LocalDateTime lastEndDate;
    private List<AdminArea> adminAreas;
    private List<Locality> localities;

    @Getter
    @Setter
    public static class AdminArea {
        private String atco_code;
        private String name;
    }

    @Getter
    @Setter
    public static class Locality {
        private String gazetteer_id;
        private String name;
    }
}
