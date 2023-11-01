package com.example.busProject.Timetable;

import com.example.busProject.API;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StopPointService {
    //might be able to add adding the query params in general.
    private static final String url = API.TFWMApiMainURL + "StopPoint/";


    public String test() {
        return getStopPointById("43000065305");
    }

    @Autowired
    private RestTemplate restTemplate;

    //maybe get all the stops for warwick and iterate through (05, 04, 03, 02, 01)
    private String getStopPointById(String id) {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("Id", id);
            pathParams.put("Arrivals", "Arrivals");

            //String urlWithPaths = General.addPathsToUrl(url, pathParams);
            String urlWithPaths = url + id + "/" + "Arrivals" + "/";

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("app_id", API.TFWMAppId);
            queryParams.put("app_key", API.TFWMAppKey);
            queryParams.put("formatter", "json");
            String finalUrl = General.buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);
            // Create ResponseEntity in format 'String' with the json data that is GOT
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    finalUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(null),
                    String.class);
            System.out.println(responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("something went wrong when trying to get from the TFWM", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling API",
                    e
            );
        }
    }

    //will probably have to GET from the line/route and then use the object to find the id for the corresponding stop
    private String getStopPointSearchData() {
        try {
            String searchQuery = "university"; //will be replaced later
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("Search", "Search");
            pathParams.put("query", searchQuery);
            String urlWithPaths = General.addPathsToUrl(url, pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("app_id", API.TFWMAppId);
            queryParams.put("app_key", API.TFWMAppKey);

            queryParams.put("formatter", "json");
            //Makes a call to the BODS API
            String finalUrl = General.buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);

            // Create ResponseEntity in format LinkedHashMap<String, Object> with the json data that is GOT
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    finalUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(null),
                    String.class);

            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("something went wrong when trying to get from the TFWM", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling API",
                    e
            );
        }
    }

//  public String getStopBySearchAsObjects(String jsonString) {
//        try {
//            //maps json data to an object
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            Container container = objectMapper.readValue(jsonString, Container.class);
//            ArrayOfLine arrayOfLine = container.getArrayOfLine();
//            StringBuilder concatenatedLineNames = new StringBuilder();
//            if (arrayOfLine != null) {
//                List<Line> lines = arrayOfLine.getLine();
//                if (lines != null) {
//                    for (Line line : lines) {
//                        concatenatedLineNames.append(" ").append(line.getName());
//                    }
//                }
//            }
//            return concatenatedLineNames.toString();
//        } catch (Exception e) {
//            log.error("Something went wrong when trying to fetch and process JSON data for stop points", e);
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while processing JSON data", e);
//        }
//    }
}
