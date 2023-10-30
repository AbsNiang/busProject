package com.example.busProject;

public interface API {
    String BODSApiMainURL = "https://data.bus-data.dft.gov.uk/api/v1/";
    String BODSKey = "8c1370c7d862d8d4dc1aa481bbb35bfcc5561e8a";
    String GTFSRT = "gtfsrt";// id comes after

    String TFWMApiMainURL = "http://api.tfwm.org.uk/";
    String TFWMAppId = "74a87464";
    String TFWMAppKey="c6b5c8512edc02ce5f373ef2b76ce568";
    /* http://api.tfwm.org.uk/Line/Route/?app_id=74a87464&app_key=c6b5c8512edc02ce5f373ef2b76ce568
     * gets all the valid routes for all lines
    */
}

/*
NOC Code	Operator Public Name	    Mode	Group
TCVW	National Express Coventry	    Bus	  National Express Group PLC
TNXB	National Express West Midlands	Bus	  National Express Group PLC
TWMD	Travel West Midlands	        Bus	  National Express Group PLC
WOOC	Woods Coaches	                Bus	  National Express Group PLC
     */

    /*
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Map<String, List<Line>>> data = objectMapper.readValue(getResponse.body(), new TypeReference<>() {
            });

            List<Line> lines = data.get("ArrayOfLine").get("Line");

            for (Line line : lines) {
                System.out.println("Id: " + line.getId());
                System.out.println("Name: " + line.getName());
                System.out.println("ModeName: " + line.getModeName());
                System.out.println("Uri: " + line.getUri());

                // Access the Operators
                Line.Operators operators = line.getOperators();
                if (operators != null) {
                    List<Line.Operator> operatorList = operators.getOperatorList();
                    if (operatorList != null) {
                        for (Line.Operator operator : operatorList) {
                            System.out.println("Operator Name: " + operator.getOperatorName());
                            System.out.println("Operator Code: " + operator.getOperatorCode());
                            System.out.println("Operator Id: " + operator.getOperatorId());
                        }
                    }
                }

                System.out.println();
                }
             */