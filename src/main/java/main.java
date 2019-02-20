import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {



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
