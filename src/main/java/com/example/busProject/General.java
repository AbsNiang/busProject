package com.example.busProject;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class General {

    // Allows us to add as many queries/paths to the URL as needed
    public static String buildURLWithPathQueryParams(String urlWithPaths, Map<String, String> pathParams,
                                                     Map<String, String> queryParams) {
        if (queryParams == null) {//only auth. params needed
            queryParams = new HashMap<>();
            queryParams.put("app_id", API.TFWMAppId);
            queryParams.put("app_key", API.TFWMAppKey);
            queryParams.put("formatter", "json");
        }else{
            queryParams.put("app_id", API.TFWMAppId);
            queryParams.put("app_key", API.TFWMAppKey);
            queryParams.put("formatter", "json");
        }

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

    // Allows us to add as many paths as needed to the URL
    public static String addPathsToUrl(String urlToUse, Map<String, String> pathParams) {
        StringBuilder extendedUrl = new StringBuilder(urlToUse);
        for (String key : pathParams.keySet()) {
            extendedUrl.append("{").append(key).append("}").append("/");
        }
        return extendedUrl.toString();
    }

    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.next();
    }
}
