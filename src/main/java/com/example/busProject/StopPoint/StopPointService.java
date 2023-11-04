package com.example.busProject.StopPoint;

import com.example.busProject.API;
import com.example.busProject.Line.Objects.ArrayOfLine;
import com.example.busProject.Line.Objects.Line;
import com.example.busProject.Line.Objects.MatchedRoute;
import com.example.busProject.Line.Objects.RouteSections;
import com.example.busProject.StopPoint.Objects.Container;
import com.example.busProject.StopPoint.Objects.Identifier;
import com.example.busProject.StopPoint.Objects.StopPoint;
import com.example.busProject.StopPoint.Objects.StopPointConnection;
import com.example.busProject.Timetable.General;
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

import java.util.*;

@Service
@Slf4j
public class StopPointService {
    //might be able to add adding the query params in general.
    private static final String url = API.TFWMApiMainURL + "StopPoint/";


    public String test() {
        return getStopPointById("43000065305");
    }

    //checks all origin stop point(s) that correlate with the search to see if they connect with the destination stop point(s)
    public String doAll(ArrayOfLine arrayOfLine, String originName, String destinationName) {
        String stopPointDataForOriginIds = getStopPointDataFromIDs(searchForStop(arrayOfLine, originName));
        String stopPointDataForDestinationIds = getStopPointDataFromIDs(searchForStop(arrayOfLine, destinationName));
        List<StopPoint> originStopPoints = mapStopPointToObject(stopPointDataForOriginIds);
        List<StopPoint> destinationStopPoints = mapStopPointToObject(stopPointDataForDestinationIds);

        List<StopPointConnection> stopPointConnections = new ArrayList<>();

        // Create a HashMap to store origin stop points and their associated lines
        Map<String, Set<String>> originLinesMap = new HashMap<>();
        for (StopPoint originStop : originStopPoints) {
            Set<String> originLines = new HashSet<>();
            for (Identifier originLine : originStop.getLines().getIdentifier()) {
                originLines.add(originLine.getId());
            }
            originLinesMap.put(originStop.getId(), originLines);
        }

        String[] pairs = new String[2]; // 0 is origin, 1 is destination
        for (StopPoint destinationStop : destinationStopPoints) {
            Set<String> destinationLines = new HashSet<>();
            for (Identifier destinationLine : destinationStop.getLines().getIdentifier()) {
                destinationLines.add(destinationLine.getId());
            }

            for (String originId : originLinesMap.keySet()) {
                Set<String> originLines = originLinesMap.get(originId);
                for (String line : originLines) {
                    if (destinationLines.contains(line)) {
                        StopPointConnection stopPointConnection = new StopPointConnection(originId,
                                destinationStop.getId(),
                                line);
                        stopPointConnections.add(stopPointConnection);
                    }
                }
            }
        }
        for (StopPointConnection stopPointConnection : stopPointConnections) {
            System.out.println("Origin ID: " + stopPointConnection.getOriginId()
                    + ", Destination ID: " + stopPointConnection.getDestinationId()
                    + ", Line ID: " + stopPointConnection.getRouteId());
        }
        return stopPointDataForOriginIds;
    }

    @Autowired
    private RestTemplate restTemplate;

    public String getLinesThatJoinStops(List<String> originalStopIds, List<String> destinationStopId) {
        return null;
    }

    //returns all the unique stop point ids that correspond to the name
    //if just concatenating string, we can get rid of the list<> for improving space complexity
    public String searchForStop(ArrayOfLine arrayOfLine, String nameSearch) {
        try {
            nameSearch = nameSearch.toLowerCase();
            List<String> stopPointIds = new ArrayList<>();
            if (arrayOfLine != null) {
                List<Line> lines = arrayOfLine.getLine();
                if (lines != null) {
                    for (Line line : lines) {

                        RouteSections routeSections = line.getRouteSections();
                        List<MatchedRoute> matchedRoutes = routeSections.getMatchedRoute();
                        for (MatchedRoute matchedRoute : matchedRoutes) {
                            String name = matchedRoute.getName().toLowerCase();
                            if (name.contains(nameSearch)) {
                                String[] nameSections = name.split(" to ");
                                if (nameSections[0].trim().contains(nameSearch.trim())) {//originator is the search
                                    String originatorId = matchedRoute.getOriginator();
                                    if (!stopPointIds.contains(originatorId)) {
                                        stopPointIds.add(originatorId);//gets the originator id
                                    }
                                } else {//if it is the destination
                                    String destinationId = matchedRoute.getDestination();
                                    if (!stopPointIds.contains(destinationId)) {
                                        stopPointIds.add(matchedRoute.getDestination());//gets the destination id
                                    }
                                }
                            } else if (matchedRoute.getOriginationName().trim().toLowerCase().contains(nameSearch.trim())) {
                                String originatorId = matchedRoute.getOriginator();
                                if (!stopPointIds.contains(originatorId)) {
                                    stopPointIds.add(originatorId);//gets the originator id
                                }
                            } else if (matchedRoute.getDestinationName().trim().toLowerCase().contains(nameSearch.trim())) {
                                String destinationId = matchedRoute.getDestination();
                                if (!stopPointIds.contains(destinationId)) {
                                    stopPointIds.add(matchedRoute.getDestination());//gets the destination id
                                }
                            }
                        }
                    }
                }
            }
            StringBuilder concatenatedIds = new StringBuilder();
            int counter = 1;
            for (String id : stopPointIds) {
                if (counter < stopPointIds.size()) {
                    concatenatedIds.append(id).append(",");
                } else {
                    concatenatedIds.append(id);
                }
                counter++;
            }
            System.out.println(stopPointIds);
            return concatenatedIds.toString();
        } catch (Exception e) {
            log.error("something went wrong when trying to handle the object", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while handling object",
                    e
            );
        }
    }

    //will probably have to GET from the line/route and then use the object to find the id for the corresponding stop
    private String getStopPointData() {
        try {
            //map of all path params (might be able to just concatenate the path to url)
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("Search", "Search");
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

    /* Loop through the list<String> of ids and print all the arrivals
     * OR check for all the lines that go to that stop, if they also go to the destination stop
     * To check if you can access on the line, try using StopPoint/{id}/canReachOnline/{lineId}
     * (make sure direction is correct)
     * */
    private List<StopPoint> mapStopPointToObject(String jsonString) {
        try {
            //maps json data to an object
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Container container = objectMapper.readValue(jsonString, Container.class);
            return container.getStopPoint().getStopPoint();
        } catch (Exception e) {
            log.error("Something went wrong when trying to fetch and process JSON data for stop points", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while processing JSON data", e);
        }
    }

//    private String getStopPointIdsIn500mBox(ArrayOfLine arrayOfLine, String nameSearch){
//        List<String> idsInBox = new ArrayList<>();
//        List<StopPoint> stopPoints = mapStopPointToObject(
//                getStopPointDataFromID(
//                        concatenateIds(searchForStop(arrayOfLine, nameSearch))));
//        for (StopPoint stopPoint: stopPoints) {
//            BoundingBox boundingBox = new BoundingBox();
//            boundingBox.setBoundingBoxForStop(stopPoint);
//            //call GET to get all stopPoints in boundingBox
//        }
//        return idsInBox.toString();
//    }

//    private String concatenateIds(List<String> ids){
//        StringBuilder joinedIds = new StringBuilder();
//        int counter = 0;
//        for (String id: ids) {
//            if (counter < ids.size()){
//                joinedIds.append(id).append("%2C");
//            }else{
//                joinedIds.append(id);
//            }
//            counter++;
//        }
//        return joinedIds.toString();
//    }

    //http://api.tfwm.org.uk/StopPoint/43000065304%2C43000065302%2C43000065301%2C43000065305?app_id=#&app_key=#
    private String getStopPointDataFromIDs(String ids) {//ids is a concatenated string of all ids with "," in between
        try {
            Map<String, String> pathParams = new HashMap<>();
            pathParams.put("ids", ids);
            String urlWithPaths = General.addPathsToUrl(url, pathParams);

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
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error occurred when trying to fetch JSON data for stop points", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while processing JSON data", e);
        }

    }

    //gets the arrivals at a particular stop point
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

    public String findRouteSectionsForSearch() {
        return null;
    }

    public String findRouteSectionsForIds() {
        return null;
    }
}//coventry stop
