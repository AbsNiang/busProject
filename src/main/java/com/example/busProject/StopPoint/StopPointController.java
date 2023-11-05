package com.example.busProject.StopPoint;

import com.example.busProject.Line.LineService;
import com.example.busProject.Line.Objects.ArrayOfLine;
import com.example.busProject.StopPoint.Objects.FormData;
import com.example.busProject.StopPoint.Objects.StopPointConnection;
import com.example.busProject.StopPoint.Objects.StopPointConnectionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stop-point")
@RequiredArgsConstructor
public class StopPointController {
    private final StopPointService stopPointService;
    private final LineService lineService;

    //can call other GETs in a different controller to get the data
    @RequestMapping("/search")
    public ResponseEntity<String> getStopPointsBySearch() {
        //return ResponseEntity.ok(lineController.getLineRoutes().toString());
        return ResponseEntity.ok(stopPointService.test());
    }

    @GetMapping("/form")
    public String formView(Model model) {
        model.addAttribute("formData", new FormData()); // Create a model attribute to hold form data
        return "form"; // This will render the "form.html" Thymeleaf template
    }

    @PostMapping("/submitForm")
    public String receiveData(@ModelAttribute("formData") FormData formData, Model model) {
        // Process the form data (formData.getOrigin(), formData.getDestination())
        System.out.println(formData.toString());
        ArrayOfLine arrayOfLine = lineService.sendDataToAnotherController();
        List<StopPointConnection> stopPointConnections = stopPointService.getStopPointConnections(
                arrayOfLine,
                formData.getOrigin(),
                formData.getDestination());
        model.addAttribute("stopPointConnections", stopPointConnections);
        return "result"; // Render the "result.html" Thymeleaf template, for instance
    }

    @GetMapping("/details/{originName}/{originId}/{destinationName}/{destinationId}/{lineName}/{lineId}")
    public String showDetails(
            @PathVariable String originName,
            @PathVariable String originId,
            @PathVariable String destinationName,
            @PathVariable String destinationId,
            @PathVariable String lineId,
            @PathVariable String lineName,
            Model model
    ) {
        StopPointConnection stopPointConnection = new StopPointConnection(
                originName, originId, destinationName, destinationId, lineName, lineId);
        // Retrieve details using the originId, destinationId, and lineId
        // Your logic here to retrieve details based on these IDs
        String jsonData = stopPointService.getLineArrivalsForOriginStopPoint(stopPointConnection);

        StopPointConnectionDetails stopPointConnectionDetails = stopPointService.getStopPointConnectionDetails(jsonData);
        // Add details to the model
        model.addAttribute("connectionDetails", stopPointConnectionDetails);

        return "details"; // Render the "details.html" Thymeleaf template
    }


    // ** instead of returning the ids as [1,2], concatenate in correct format with %2C already - searchForStop
    // ** parse those to a method which gets stop-pointData for each id - getStopPointDataFromIDs
    // ** parse that data to objects
    // ** for each stop point check the lines and check if that line goes to the destination
    // ** return the stop points and lines which can be joined
    // ** make it so that you can input the origin and destination in the web app
    // ** return the connections in the web app neatly
    // ** get the arrival times for that line at the origin stop
    // ** maybe get the arrival times for that line at the destination
    // make it so that if any of the fields is empty, the connection is removed
    // double check that the direction / towards is correct.
    // deploy to AWS
    // eventually, if none, get a bounding box with increasing area until a stop-point is found.
    // eventually, get ip of user with API and use a geolocation API to get a  bounding box for an area search
}
