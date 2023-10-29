package com.example.busProject.Location;

import com.example.busProject.API;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
@Slf4j
public class LocationService {
    //boundingBox is a lot more useful, allows us to automate choosing services to look at
    private final String url = API.apiMainURL + "datafeed/";

    public void getLocationData() {
        FetchData.getData(url, bbParams(51.401, 51.509, 0.01, 0.201));//National express west midlands
    }

    //sets boundingBox parameters
    private static String bbParams(double minLong, double minLat, double maxLong, double maxLat) {//longitude and latitude
        return "boundingBox=" + minLong + "," + minLat + "," + maxLong + "," + maxLat;
    }



    private RestTemplate restTemplate;

    public LocationService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Object getOverallLocationData() {
        try {
            System.out.println("hit start");
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("datafeedId", "10609");//order of path params matters
            String urlWithPaths = addPathsToUrl(pathParams);

            //map of all query params
            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("boundingBox", "51.401,51.509,0.01,0.201");
            queryParams.put("api_key", API.key);

            //set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.ALL));

            String finalUrl = buildURLWithPathQueryParams(urlWithPaths, pathParams, queryParams);
            System.out.println(finalUrl);
            HttpEntity<?> entity = new HttpEntity<>(headers);//add headers

            // Make the request to the API//
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.GET, entity, String.class);
            System.out.println("reached: " + response);
            return response;
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
//        return restTemplate.getForObject(finalUrl, Object.class);
    }

    private String addPathsToUrl(Map<String, String> pathParams) {
        StringBuilder extendedUrl = new StringBuilder(url);
        for (String key : pathParams.keySet()) {
            extendedUrl.append("{").append(key).append("}").append("/");
        }
        return extendedUrl.toString();
    }
}
