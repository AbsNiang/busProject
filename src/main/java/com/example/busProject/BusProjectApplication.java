package com.example.busProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusProjectApplication.class, args);
	}


	//This @Bean was used to store the csv data in the DB
//	@Bean
//	public CommandLineRunner runDataImport(SaveCSVDataInDB dataImporter) {
//		return args -> {
//			// This will execute the CSV data import logic after the Spring context has initialized.
//			dataImporter.saveObjectsInDatabase();
//		};
//	}
}
