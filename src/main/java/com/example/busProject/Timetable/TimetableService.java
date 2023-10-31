package com.example.busProject.Timetable;

import com.example.busProject.API;
import com.example.busProject.Timetable.Objects.ArrayOfLine;
import com.example.busProject.Timetable.Objects.Container;
import com.example.busProject.Timetable.Objects.Line;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TimetableService {

    private static final String bodsUrl = API.BODSApiMainURL + "dataset/";
    private static final String tfwmUrl = API.TFWMApiMainURL + "line/";

    @Autowired
    private RestTemplate restTemplate;

    public String test() {
        String jsonData = getLineRoutes();
        System.out.println(jsonData);
        return getLineRoutesAsObjects(jsonData);
    }

    //Could use JSON parser instead: gson dependency
    public String getLineRoutesAsObjects(String jsonString) {
        try {
            //maps json data to an object
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Container container = objectMapper.readValue(jsonString, Container.class);
            ArrayOfLine arrayOfLine = container.getArrayOfLine();
            StringBuilder concatenatedLineNames= new StringBuilder();
            if (arrayOfLine != null){
                List<Line> lines = arrayOfLine.getLine();
                if (lines!=null){
                    for (Line line: lines){
                        concatenatedLineNames.append(" ").append(line.getName());
                    }
                }
            }
            return concatenatedLineNames.toString();
        } catch (Exception e) {
            log.error("Something went wrong when trying to fetch and process XML data for line routes", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while processing XML data", e);
        }
    }


    public Object getAllTimetables() {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            //pathParams.put("datasetId", "464");// {datasetId}/download downloads the zip w all the data
            String urlWithPaths = addPathsToUrl(bodsUrl, pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("api_key", API.BODSKey);
            queryParams.put("limit", "10000");
            //Makes a call to the BODS API
            return buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);
        } catch (Exception e) {
            log.error("something went wrong when trying to get from the BODS API", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling API",
                    e
            );
        }
    }

    //builds the url by adding the query parameters dynamically
    private String buildURLWithPathQueryParams(String urlWithPaths, Map<String, String> pathParams,
                                               Map<String, String> queryParams) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlWithPaths);
        //Add path params
        UriComponents uriComponents = builder.buildAndExpand(pathParams);
        UriComponentsBuilder finalBuilder = UriComponentsBuilder.fromUri(uriComponents.toUri());
        //add query params
        queryParams.forEach(finalBuilder::queryParam);

        String finalUrl = finalBuilder.toUriString();
        System.out.println(finalUrl);
        return finalUrl;
    }

    private String addPathsToUrl(String urlToUse, Map<String, String> pathParams) {
        StringBuilder extendedUrl = new StringBuilder(urlToUse);
        for (String key : pathParams.keySet()) {
            extendedUrl.append("{").append(key).append("}").append("/");
        }
        return extendedUrl.toString();
    }

    public String getLineRoutes() {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("route", "route");// want to get the line route
            String urlWithPaths = addPathsToUrl(tfwmUrl, pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("app_id", API.TFWMAppId);
            queryParams.put("app_key", API.TFWMAppKey);
            queryParams.put("formatter", "json");
            //Makes a call to the BODS API
            String finalUrl = buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);

            // Create ResponseEntity in format LinkedHashMap<String, Object> with the json data that is GOT
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    finalUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(null),
                    String.class);

            return responseEntity.getBody();
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
