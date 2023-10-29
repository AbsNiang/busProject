package com.example.busProject.Timetable;

import com.example.busProject.API;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TimetableService {

    // nationalExpressId = "12856"
    // stagecoachId = "6847"
    private static final String url = API.apiMainURL + "dataset/";

    /*
    public static void getTimetableData() {
        FetchData.getData(API.forTimetableData, "idfiller");
    }
    */

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllTimetables() {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("datasetId", "464");// {datasetId}/download downloads the zip w all the data
            String urlWithPaths = addPathsToUrl(pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("api_key", API.key);
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
    private Object buildURLWithPathQueryParams(String urlWithPaths, Map<String, String> pathParams,
                                               Map<String, String> queryParams) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlWithPaths);
        //Add path params
        UriComponents uriComponents = builder.buildAndExpand(pathParams);
        UriComponentsBuilder finalBuilder = UriComponentsBuilder.fromUri(uriComponents.toUri());
        //add query params
        queryParams.forEach(finalBuilder::queryParam);

        String finalUrl = finalBuilder.toUriString();
//        System.out.println(finalUrl);
        return restTemplate.getForObject(finalUrl, Object.class);
    }

    private String addPathsToUrl(Map<String, String> pathParams) {
        StringBuilder extendedUrl = new StringBuilder(url);
        for (String key : pathParams.keySet()) {
            extendedUrl.append("{").append(key).append("}").append("/");
        }
        return extendedUrl.toString();
    }
}
