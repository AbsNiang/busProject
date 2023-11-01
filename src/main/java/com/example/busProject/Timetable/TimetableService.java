package com.example.busProject.Timetable;

import com.example.busProject.API;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TimetableService {

    private static final String bodsUrl = API.BODSApiMainURL + "dataset/";

    public Object getAllTimetables() {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            //pathParams.put("datasetId", "464");// {datasetId}/download downloads the zip w all the data
            String urlWithPaths = General.addPathsToUrl(bodsUrl, pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("api_key", API.BODSKey);
            queryParams.put("limit", "10000");
            //Makes a call to the BODS API
            return General.buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);
        } catch (Exception e) {
            log.error("something went wrong when trying to get from the BODS API", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling API",
                    e
            );
        }
    }
}
