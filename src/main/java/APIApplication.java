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
        CSV csv = new CSV();
        List<CSVPerson> csvPeople = csv.load("generated.csv");

        //write said bean
        //this took way longer than anticipated
        WriteCSVOriginal writeCSVOriginal = new WriteCSVOriginal();
        writeCSVOriginal.write(csvPeople, "generated_original.csv");

        //write something altered
        //should be fun
        WriteCSVAltered writeCSVAltered = new WriteCSVAltered();
        writeCSVAltered.writeAltered(csvPeople, "generated_altered.csv");
        */
    }
}
