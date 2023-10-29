package com.example.busProject.CsvStopData;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SaveCSVDataInDB {
    private List<BusStop> csvToObject() {
        try {
            //read CSV file
            String csvFilePath = "Stops.csv";
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(csvFilePath))
                    .withSkipLines(1)
                    .build();

            List<BusStop> busStopList = new ArrayList<>();
            String[] nextRecord;
            int recordCountForDebug = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                recordCountForDebug++;
                for (int i = 0; i < nextRecord.length; i++) {
                    if (nextRecord[i] != null && nextRecord[i].contains("\\")) {
                        nextRecord[i] = nextRecord[i].replace("\\", "\\\\");
                    }
                }
                if (!nextRecord[22].equalsIgnoreCase("inactive")) {
                    BusStop busStop = new BusStop();

                    busStop.setAtcoCode(nextRecord[0]);//good
                    busStop.setNaptanCode(nextRecord[1]);//good
                    busStop.setPlateCode(nextRecord[2]);//good
                    busStop.setCommonName(nextRecord[3]);//good
                    busStop.setShortCommonName(nextRecord[4]);//good
                    busStop.setLandmark(nextRecord[5]);//
                    busStop.setStreet(nextRecord[6]);
                    busStop.setIndicator(nextRecord[7]);
                    busStop.setBearing(nextRecord[8]);
                    busStop.setNptgLocalityCode(nextRecord[9]);
                    busStop.setLocalityName(nextRecord[10]);
                    busStop.setParentLocalityName(nextRecord[11]);
                    busStop.setTown(nextRecord[12]);
                    busStop.setSuburb(nextRecord[13]);
                    busStop.setLocalityCentre(nextRecord[14]);
                    try {
                        busStop.setEasting(nextRecord[15].isEmpty() ? 0 : Integer.parseInt(nextRecord[15]));
                        busStop.setNorthing(nextRecord[16].isEmpty() ? 0 : Integer.parseInt(nextRecord[16]));
                        busStop.setLongitude(nextRecord[17].isEmpty() ? 0.0 : Double.parseDouble(nextRecord[17]));
                        busStop.setLatitude(nextRecord[18].isEmpty() ? 0.0 : Double.parseDouble(nextRecord[18]));
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        log.error("error parsing numerical data. check csv formatting");
                        log.error("failed to parse values from csv line: " + Arrays.toString(nextRecord));
                        int counter = 0;
                        for (String part : nextRecord) {
                            log.error(counter + ":" + part);
                            counter++;
                        }
                        log.error("record: " + recordCountForDebug);
                        throw new RuntimeException("Failed to parse numerical data");
                    }

                    busStop.setStopType(nextRecord[19]);
                    busStop.setBusStopType(nextRecord[20]);
                    busStop.setTimingStatus(nextRecord[21]);
                    busStop.setAdminAreaCode(nextRecord[22]);
                    busStop.setStatus(nextRecord[23]);

                    busStopList.add(busStop);
                }
            }
            csvReader.close();
            return busStopList;
        } catch (Exception e) {
            log.error("Something went wrong when trying to parse the CSV data.");
            throw new RuntimeException("Failed to parse CSV file", e);
        }
    }

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public SaveCSVDataInDB(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    public void saveObjectsInDatabase() {
        List<BusStop> busStops = csvToObject();

        // Create EntityManager and persist the data to the database
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //begins transaction
        entityManager.getTransaction().begin();

        for (BusStop busStop : busStops) {
            entityManager.persist(busStop);
        }

        //commits transaction
        entityManager.getTransaction().commit();

        //closes entity manager
        entityManager.close();
        entityManagerFactory.close();
        checkDataAdded();
    }

    private void checkDataAdded() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT b FROM BusStop b");
        List<BusStop> busStops = query.getResultList();

        if (busStops.isEmpty()) {
            System.out.println("No data found in the database.");
        } else {
            System.out.println("Data successfully added to the database:");
            for (BusStop busStop : busStops) {
                System.out.println(busStop); // Print or log the retrieved BusStop data
            }
        }
        entityManager.close();
    }
}
