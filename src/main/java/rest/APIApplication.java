package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APIApplication {

    public static void main(String[] args) {

        SpringApplication.run(APIApplication.class, args);

        //All of the below needs to be moved to a rest call where befitting
        //Where that is exactly will become clear in a future commit
        /*
        //load bean into memory
        csv.CSV csv = new csv.CSV();
        List<csv.CSVPerson> csvPeople = csv.load("generated.csv");

        //write said bean
        //this took way longer than anticipated
        csv.WriteCSVOriginal writeCSVOriginal = new csv.WriteCSVOriginal();
        writeCSVOriginal.write(csvPeople, "generated_original.csv");

        //write something altered
        //should be fun
        csv.WriteCSVAltered writeCSVAltered = new csv.WriteCSVAltered();
        writeCSVAltered.writeAltered(csvPeople, "generated_altered.csv");
        */
    }
}
